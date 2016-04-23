package the.vince.huangyongsheng;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class HeiDouActivity extends AppCompatActivity {

    private String Message="";
    private TextView mTv_material;
    private TextView mTv_method;
    private TextView mTv_effect;
    private CheckBox mCb_material;
    private CheckBox mCb_method;
    private CheckBox mCb_effect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hei_dou);
        initView();
    }
    /**
     * 处理事件, 发送邮件
     */
    public void sendToEmail(View view) {
        //获取数据
        initData();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "黑豆鲫鱼汤");
        intent.putExtra(Intent.EXTRA_TEXT, Message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        Message = "";//清空文本
    }

    /**
     * 处理数据
     */
    private void initData() {
        if (mCb_material.isChecked()) {
            Message = "材料:\n" + mTv_material.getText().toString() + "\n\n";
        }

        if (mCb_method.isChecked()) {
            Message += "做法:\n" + mTv_method.getText().toString() + "\n\n";
        }

        if (mCb_effect.isChecked()) {
            Message += "功效:\n" + mTv_effect.getText().toString();
        }
    }

    /**
     * 初始化数据
     */
    private void initView() {
        //材料
        mTv_material = (TextView) findViewById(R.id.tv_material);

        //做法
        mTv_method = (TextView) findViewById(R.id.tv_method);

        //功效
        mTv_effect = (TextView) findViewById(R.id.tv_effect);

        //获取CheckBox
        mCb_material = (CheckBox) findViewById(R.id.cb_material);
        mCb_method = (CheckBox) findViewById(R.id.cb_method);
        mCb_effect = (CheckBox) findViewById(R.id.cb_effect);

    }
}
