package com.yangzk.tank.v3;

/**
 * 开火策略接口
 */
public interface FireStrategy {
    /**
     * 开火
     */
    void fire(Tank tank);
}
