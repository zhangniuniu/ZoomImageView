package test.zoom.zoomview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Context mContext = null;
    private ViewPager mViewPager = null;

    private int[] mImgs = new int[] {
            R.drawable.p1 ,
            R.drawable.p2 ,
            R.drawable.p3
    };

    private ImageView[] mImageViews = new ImageView[mImgs.length];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_viewpager);

        mContext = MainActivity.this;
        mViewPager = (ViewPager) findViewById(R.id.id_viewPager);
        mViewPager.setAdapter(new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ZoomImageView zoomImageView = new ZoomImageView(mContext);
                zoomImageView.setImageResource(mImgs[position]);
                container.addView(zoomImageView);
                //???ImageView?????????????????????ZoomImageView??????????????????
                mImageViews[position] = zoomImageView;
                return zoomImageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                //??????ImageView???????????��???
                container.removeView(mImageViews[position]);
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                return mImageViews.length;
            }
        });
    }

}
