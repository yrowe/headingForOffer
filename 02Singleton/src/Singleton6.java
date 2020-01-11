/**
 * 枚举类实现
 *
 * @Author rowe
 * @Date 2020/1/11 19:40
 */
public enum  Singleton6 {
    INSTANCE;

    private String objName;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args) {
        Singleton6 singleton6 = Singleton6.INSTANCE;
    }


}
