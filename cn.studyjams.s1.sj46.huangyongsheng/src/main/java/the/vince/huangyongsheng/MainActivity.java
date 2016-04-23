package the.vince.huangyongsheng;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] bitmaoId = {R.drawable.dong_gua,R.drawable.hei_dou,R.drawable.dong_gu_ji};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.iv_head);

        AnimationDrawable animationDrawable = new AnimationDrawable();
        for(int i =0;i<3;i++){

           // int Id = getResources().getIdentifier(bitmaoId[i]+"","drawable",getPackageName());
            animationDrawable.addFrame(getResources().getDrawable(bitmaoId[i]),2000);
        }
        animationDrawable.setOneShot(false);
        imageView.setImageDrawable(animationDrawable);
        animationDrawable.start();
    }

    public void open(View view){
        switch (view.getId()){
            case R.id.bt_dg:
                Intent intent1 = new Intent(this,DongGuaActivity.class);
                startActivity(intent1);
                break;
            case R.id.bt_dgj:
                Intent intent2 = new Intent(this,DongGuActivity.class);
                startActivity(intent2);
                break;
            case R.id.bt_hd:
                Intent intent3 = new Intent(this,HeiDouActivity.class);
                startActivity(intent3);
                break;
            case R.id.bt_about:
                Intent intent = new Intent(this,AboutMeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
