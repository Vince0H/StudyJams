package the.vince.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    //设置 A B 对的分数全局变量
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private Button mBt_teamA_three;
    private Button mBt_teamB_three;
    private Button mBt_teamA_two;
    private Button mBt_teamB_two;
    private Button mBt_teamA_one;
    private Button mBt_teamB_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        initView();
    }

    /**
     * 绑定 6个 得分按钮, 并设置为全局变量
     */
    private void initView() {
        mBt_teamA_three = (Button) findViewById(R.id.bt_three_a);
        mBt_teamB_three = (Button) findViewById(R.id.bt_three_b);

        mBt_teamA_two = (Button) findViewById(R.id.bt_two_a);
        mBt_teamB_two = (Button) findViewById(R.id.bt_two_b);

        mBt_teamA_one = (Button) findViewById(R.id.bt_one_a);
        mBt_teamB_one = (Button) findViewById(R.id.bt_one_b);

    }

    /**
     * 得分
     *
     * @param view 传入的View的ID不同, 来区别是不同的Button
     */
    public void addScoreForTeam(View view) {
        //监听不同的得分Button
        switch (view.getId()) {
            case R.id.bt_three_a:
                scoreTeamA += 3;
                break;
            case R.id.bt_two_a:
                scoreTeamA += 2;
                break;
            case R.id.bt_one_a:
                scoreTeamA += 1;
                break;
            case R.id.bt_three_b:
                scoreTeamB += 3;
                break;
            case R.id.bt_two_b:
                scoreTeamB += 2;
                break;
            case R.id.bt_one_b:
                scoreTeamB += 1;
                break;
            default:
                break;
        }
        displayRorTeamA(scoreTeamA);
        displayRorTeamB(scoreTeamB);
    }

    /**
     * 显示Team a 的分数
     *
     * @param teamScore
     */
    public void displayRorTeamA(int teamScore) {
        //获取显示的控件
        TextView tv_teamA = (TextView) findViewById(R.id.team_a_score);
        //设置TextView的数值
        tv_teamA.setText("" + teamScore);
    }

    /**
     * 显示 Team b 的分数
     *
     * @param teamScore
     */
    public void displayRorTeamB(int teamScore) {
        //获取显示的控件
        TextView tv_teamB = (TextView) findViewById(R.id.team_b_score);
        //设置TextView的数值
        tv_teamB.setText("" + teamScore);
    }

    public void reset(View v) {
        //将 A B 队的分数归 0
        scoreTeamA = 0;
        scoreTeamB = 0;
        //显示归 0 后的分数
        displayRorTeamA(scoreTeamA);
        displayRorTeamB(scoreTeamB);
    }
}
