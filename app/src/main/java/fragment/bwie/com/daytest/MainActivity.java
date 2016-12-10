package fragment.bwie.com.daytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //定义一个容器
    private List<String> path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//初始化控件
        initViews();
    }

    private void initViews() {
        GridView mGridView = (GridView) findViewById(R.id.grid_view);
        path = new ArrayList<>();
        /**
         * http://xinshipu.cn/20110528/smallImage1/1306536264861.jpg
         http://xinshipu.cn/20100506/smallImage1/1273157301640.jpg
         http://xinshipu.cn/20110721/smallImage1/1311234728768.jpg
         http://xinshipu.cn/20100605/smallImage1/1275738758736.jpg
         http://xinshipu.cn/20100506/smallImage1/1273106865078.jpg
         http://xinshipu.cn/20100613/smallImage1/1276425889259.jpg
         http://xinshipu.cn/20100521/original/1274403878791.jpg
         http://xinshipu.cn/20110403/smallImage1/1301805300564.jpg
         http://xinshipu.cn/20100325/smallImage1/1269459830286.jpg
         http://xinshipu.cn/20150102/original/1420152641128.jpg
         http://xinshipu.cn/20100809/smallImage1/1281348073140.jpg
         http://xinshipu.cn/20140706/smallImage1/1404599235077.jpg
         http://xinshipu.cn/20100325/smallImage1/1269495282911.jpg
         http://xinshipu.cn/20130320/smallImage1/1363712079835.jpg
         http://xinshipu.cn/20100323/smallImage1/1269319132942.jpg
         http://xinshipu.cn/20100325/smallImage1/1269465144254.jpg
         http://xinshipu.cn/20110627/smallImage1/1309127322498.jpg
         http://xinshipu.cn/20150312/original/1426129355728.jpg
         */
        //添加网络上的数据
        path.add("http://xinshipu.cn/20150312/original/1426129355728.jpg");
        path.add("http://xinshipu.cn/20110627/smallImage1/1309127322498.jpg");
        path.add(" http://xinshipu.cn/20100325/smallImage1/1269465144254.jpg");
        path.add("http://xinshipu.cn/20100323/smallImage1/1269319132942.jpg");
        path.add("  http://xinshipu.cn/20130320/smallImage1/1363712079835.jpg");
        path.add("http://xinshipu.cn/20100325/smallImage1/1269495282911.jpg");
        path.add(" http://xinshipu.cn/20140706/smallImage1/1404599235077.jpg");
        path.add("http://xinshipu.cn/20100809/smallImage1/1281348073140.jpg");
        path.add("http://xinshipu.cn/20150102/original/1420152641128.jpg");
        path.add("http://xinshipu.cn/20100325/smallImage1/1269459830286.jpg");
        path.add("  http://xinshipu.cn/20110403/smallImage1/1301805300564.jpg");
        path.add("  http://xinshipu.cn/20100521/original/1274403878791.jpg");
        path.add(" http://xinshipu.cn/20100613/smallImage1/1276425889259.jpg");
        path.add(" http://xinshipu.cn/20100506/smallImage1/1273106865078.jpg");
        path.add("http://xinshipu.cn/20100605/smallImage1/1275738758736.jpg");
        path.add("http://xinshipu.cn/20110721/smallImage1/1311234728768.jpg");
        path.add("http://xinshipu.cn/20100506/smallImage1/1273157301640.jpg");
        path.add("http://xinshipu.cn/20110721/smallImage1/1311234728768.jpg");
        path.add("http://xinshipu.cn/20110528/smallImage1/1306536264861.jpg");
        //gridView添加一个适配器
        mGridView.setAdapter(new MyAdapter());
    }

    //自定义一个内部类适配器
    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return path.size();
        }

        @Override
        public Object getItem(int position) {
            return path.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(MainActivity.this, R.layout.grid_item, null);
                holder.imageView = (ImageView) convertView.findViewById(R.id.image_view);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            BitmapUtils bm = new BitmapUtils(MainActivity.this);
            bm.display(holder.imageView, path.get(position));
            return convertView;
        }
    }

    class ViewHolder {
        ImageView imageView;
    }
}
