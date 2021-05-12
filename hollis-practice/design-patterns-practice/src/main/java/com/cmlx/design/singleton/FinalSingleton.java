package com.cmlx.design.singleton;

/**
 * @Author CMLX
 * @Date -> 2021/5/12 11:05
 * @Desc -> 使用final
 **/

class FinalWrapper<T> {
    public final T value;

    public FinalWrapper(T value) {
        this.value = value;
    }
}


public class FinalSingleton {

    private FinalWrapper<FinalSingleton> helperWrapper = null;

    public FinalSingleton getHelper() {
        FinalWrapper<FinalSingleton> wrapper = helperWrapper;

        if (wrapper == null) {
            synchronized (this) {
                if (helperWrapper == null) {
                    helperWrapper = new FinalWrapper<FinalSingleton>(new FinalSingleton());
                }
                wrapper = helperWrapper;
            }
        }
        return wrapper.value;
    }

}
