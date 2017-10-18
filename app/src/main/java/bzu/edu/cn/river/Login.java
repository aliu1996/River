package bzu.edu.cn.river;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
/**
 * Created by LG on 2017/10/16.
 */
public class Login extends AppCompatActivity {
    private long exitTime = 0;
    private EditText user;
    private EditText password;
    private CheckBox remeber;
    private CheckBox auto;
    private Button login1;
    private SharedPreferences sp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        sp = getSharedPreferences("config", MODE_PRIVATE);
       user = (EditText) findViewById(R.id.editText1);
        password = (EditText) findViewById(R.id.editText2);
       remeber = (CheckBox) findViewById(R.id.radioButton1);
        auto = (CheckBox) findViewById(R.id.radioButton2);
        //获取sp里面存储的数据
        String savedQQ = sp.getString("user", "");
        String savedPassword = sp.getString("password", "");
        user.setText(savedQQ);
        password.setText(savedPassword);

       login1= (Button) findViewById(R.id.btn2);
        // 给按钮注册一个点击事件。
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String users = user.getText().toString();
                String passwords = password.getText().toString();
                if (TextUtils.isEmpty(users) || TextUtils.isEmpty(passwords)) {
                    Toast.makeText(getApplicationContext(),
                            "对不起，账号" + "或者密码不能为空",Toast.LENGTH_LONG).show();
                } else {
                    // 检查用户是否勾选了 记住密码的选项。
                    if (remeber.isChecked()) {
                        // 说明勾选框被选中了。把用户名和密码给记录下来
                        // 获取到一个参数文件的编辑器。
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("user", users);
                        editor.putString("password", passwords);  // 把数据给保存到sp里
                        editor.commit();
                        Toast.makeText(getApplicationContext(), "用户信息已经保存",Toast.LENGTH_LONG)
                                .show();
                    }
                }
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

