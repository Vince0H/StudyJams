package the.vince.myorder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        //获取名字
        EditText et_name = (EditText) findViewById(R.id.et_name);
        String name = et_name.getText().toString().trim();

        //是否添加cream
        CheckBox cb_WCream = (CheckBox) findViewById(R.id.cb_whipped);
        boolean hasWhippedCream = cb_WCream.isChecked();

        //是否添加chocolate
        CheckBox cb_chocolate = (CheckBox) findViewById(R.id.cb_chocolate);
        boolean hasChocolate = cb_chocolate.isChecked();

        //获取价格
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        //获取清单
        String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
        //显示清单
        displayMessage(priceMessage);

        sendToEmail(priceMessage);
    }

    /**
     * 发送Email
     * @param priceMessage
     */
    private void sendToEmail(String priceMessage) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT,"This email from SJ46");
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }


    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int price = 5;
        //加 WhippedCream 加1块
        if (hasWhippedCream == true) {
            price++;
        }
        //加 hasChocolate 加2块
        if (hasChocolate == true) {
            price += 2;
        }
        return number * price;
    }

    /**
     * 显示清单
     *
     * @param name
     * @param price
     * @param hasWhippedCream
     * @param hasChocolate
     * @return
     */
    private String createOrderSummary(String name, int price, boolean hasWhippedCream, boolean
            hasChocolate) {
        String priceMessage = "name: " + name;
        priceMessage += "\nAdd Whipped cream ?" + hasWhippedCream;
        priceMessage += "\nAdd hasChocolate ?" + hasChocolate;
        priceMessage += "\nQuantity:" + number;
        priceMessage += "\nTotal : " + NumberFormat.getCurrencyInstance().format(price);
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * + 号点击事件
     *
     * @param v
     */
    public void increment(View v) {
        //设置上限
        if (number == 100) {
            Toast.makeText(this,"You cannot have more than 100 coffees",Toast.LENGTH_SHORT).show();
            return;
        }
        number++;
        display(number);
    }

    /**
     * - 号点击事件
     *
     * @param v
     */
    public void decrement(View v) {
        //防止减少到0以下
        if (number == 1) {
            Toast.makeText(this,"You cannot have less than 1 coffees",Toast.LENGTH_SHORT).show();
            return;
        }
        number--;
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
        TextView tv_displayPrice = (TextView) findViewById(R.id.order_summary_text_view);
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
