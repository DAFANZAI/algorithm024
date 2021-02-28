import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class RobotSim_874 {
    /**
     * 基本思想：模拟机器人行走的过成，每走一步计算当前点到原点的距离平方，实时更新最大值
     * 用x,y坐标模拟机器人行走方向：x = {0, 1, 0, -1};y = {1, 0, -1, 0};
     * (0, 1)->向上：当前方向值为0，对应x[0],y[0]
     * (1, 0)->向右：当前方向值为1，对应x[1],y[1]
     * (0, -1)->向下：当前方向值为2，对应x[2],y[2]
     * (-1, 0)->向左：当前方向值为3，对应x[3],y[3]
     * 方向指令-1（向右旋转90度）：当前方向值+1
     * 方向指令-2（向左旋转90度）：当前方向值+3
     * 用一个set存储障碍物集合，每走一步判断是否遇到障碍物
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};
        int curX = 0;
        int curY = 0;
        int result = 0;
        //定义障碍物集合
        Set<Pair<Integer,Integer>> obstacleSet = new HashSet<>();
        for(int i = 0; i < obstacles.length; i++) {
            obstacleSet.add(new Pair<>(obstacles[i][0], obstacles[i][1]));
        }
        int curDire = 0;
        for(int i = 0; i < commands.length; i++) {
            if(commands[i] == -1) {
                curDire = (curDire + 1) % 4;
            }else if(commands[i] == -2) {
                curDire = (curDire + 3) % 4;
            }else {
                for(int j = 0; j < commands[i]; j++) {
                    int newX = curX + x[curDire];
                    int newY = curY + y[curDire];
                    if(!obstacleSet.contains(new Pair<>(newX, newY))) {
                        curX = newX;
                        curY = newY;
                        result = Math.max(result, curX*curX + curY*curY);
                    }else {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
