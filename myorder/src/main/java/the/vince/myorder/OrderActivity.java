package the.vince.myorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class OrderActivity extends AppCompatActivity {

    private int number = 0;//数量的全局变量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }

    /**
     * order按钮点击事件
     *
     * @param v
     */
    public void submitOrder(View v) {
        int price = number * 5;
        //在价格的前面显示 人民币的符号
        String priceMessage = "Total : " + NumberFormat.getCurrencyInstance().format(price);
        priceMessage += "\nThank you!";
        displayMessage(priceMessage);
    }

    /**
     * + 号点击事件
     *
     * @param v
     */
    public void increment(View v) {
        number++;
        display(number);
    }

    /**
     * - 号点击事件
     *
     * @param v
     */
    public void decrement(View v) {
        number--;
        //防止减少到0以下
        if (number < 0) {
            number = 0;
        }
        display(number);
    }

    /**
     * 清零
     *
     * @param v
     */
    public void clear(View v) {
        number = 0;
        display(number);
        displayMessage(number + "");
    }

    /**
     * 总价显示的结果
     *
     * @param priceMessage
     */
    private void displayMessage(String priceMessage) {
        //获取显示的控件
        TextView tv_displayPrice = (TextView) findViewById(R.id.price_text_view);
        //设置TextView的数值
        tv_displayPrice.setText(priceMessage);
    }

    /**
     * @param number 增加的数值
     */
    private void display(int number) {
        //获取显示的控件
        TextView tv_quantity = (TextView) findViewById(R.id.quantity_text_view);
        //设置TextView的数值
        tv_quantity.setText("" + number);
    }

}
