package com.zxg.hasee.mysexygirl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.list_view)
    ListView mListView;
    List<SexyGirlBean.NewslistBean> mListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadDataFromServer();
    }

    private void loadDataFromServer() {
        String url = "http://apis.baidu.com/txapi/mvtp/meinv?num=10";
        SexyGirlRequest<SexyGirlBean> request = new SexyGirlRequest<>(url, SexyGirlBean.class
                , listener, errorListener);
        NetWorkManager.sendRequest(request);
    }

    private Response.Listener<SexyGirlBean> listener = new Response.Listener<SexyGirlBean>() {
        @Override
        public void onResponse(SexyGirlBean response) {
            if (response != null) {
                Log.d(TAG, "onResponse:" + response.getNewslist().size());
                mListData = response.getNewslist();
                mListView.setAdapter(mBaseAdapter);
            }
        }
    };

    private BaseAdapter mBaseAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return mListData == null ? 0 : mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, android.view.View convertView, ViewGroup parent) {
            ViewHolder mViewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_item, null);
                mViewHolder = new ViewHolder(convertView);
                convertView.setTag(mViewHolder);
            } else {
                mViewHolder = (ViewHolder) convertView.getTag();
            }
            SexyGirlBean.NewslistBean data = mListData.get(position);
            //标题
            mViewHolder.mTextView.setText(mListData.get(position).getTitle());
            //刷新图片
            Glide.with(MainActivity.this).load(data.getPicUrl())
                    .bitmapTransform(/*new BlurTransformation(MainActivity.this),*/
                            new CropCircleTransformation(MainActivity.this))
                    .into(mViewHolder.mImageView);
            return convertView;
        }
    };

    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d(TAG, "onErrorResponse:网络请求失败" + error.getNetworkTimeMs());
        }
    };

    public class ViewHolder {
        /* ImageView mImageView;
         TextView mTextView;
         public ViewHolder(View root){
             mImageView = (ImageView) root.findViewById(R.id.list_image);
             mTextView = (TextView) root.findViewById(R.id.list_textview);
         }*/
        @BindView(R.id.list_image)
        public ImageView mImageView;
        @BindView(R.id.list_textview)
        TextView mTextView;

        public ViewHolder(View root) {
            ButterKnife.bind(this, root);
        }
    }

}
