package cn.lovepet.shops.view.adapter;

import android.view.View;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import cn.lovepet.shops.R;
import cn.lovepet.shops.bean.GoodsNewsBean;
import cn.lovepet.shops.helper.basequickadapter.BaseQuickAdapter;
import cn.lovepet.shops.helper.basequickadapter.BaseViewHolder;

/**
 * 商品咨询数据适配器
 */

public class GoodsNewsAdapter extends BaseQuickAdapter<GoodsNewsBean.ContentBean,BaseViewHolder> {

    public GoodsNewsAdapter(int layoutResId) {
        super(layoutResId);
    }
    @Override
    protected void convert(BaseViewHolder helper, final GoodsNewsBean.ContentBean bean , int position) {
        helper.setText(R.id.title_text,bean.title);
        helper.setText(R.id.content_text,bean.summary);
        helper.setText(R.id.author_name , bean.authorName);
        helper.setText(R.id.time_text , bean.showTime);
        helper.setText(R.id.page_view_count , ""+bean.pageView);
        SimpleDraweeView simpleDraweeView = helper.getView(R.id.content_img);
        SimpleDraweeView authorImg = helper.getView(R.id.author_img);
        simpleDraweeView.setImageURI(bean.indexImage);
        authorImg.setImageURI(bean.authorPic);
        helper.addOnClickListener(R.id.find_item_layout);

        setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public boolean onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(mContext, "第"+position+"条 ", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


}
