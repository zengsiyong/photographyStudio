package pojo2;

/**
 * Created by zengsy on 2017-10-09.
 * 这是用户类
 * getAnonymousName表示获取本用户的匿名名称，在评价的时候显示用户名使用。
 */
public class User {
    private String password;
    private String name;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // getAnonymousName表示获取本用户的匿名名称，在评价的时候显示用户名使用。
    public String getAnonymousName(){
        if(null==name)
            return null;

        if(name.length()<=1)
            return "*";

        if(name.length()==2)
            return name.substring(0,1) +"*";

        char[] cs =name.toCharArray();
        for (int i = 1; i < cs.length-1; i++) {
            cs[i]='*';
        }
        return new String(cs);

    }

}
