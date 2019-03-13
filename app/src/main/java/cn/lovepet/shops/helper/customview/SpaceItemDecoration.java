package cn.lovepet.shops.helper.customview;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cn.lovepet.shops.util.DensityUtil;

/**
 * @author JSYL-DCL
 * @date 2018/12/6 11:16
 * @des 间距
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration{
    private Context context;
    public SpaceItemDecoration(Context context) {
        this.context = context;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int delta = DensityUtil.dip2px(context, 5);
        //由于每行都只有3个，所以第一个都是3的倍数，把左边距设为0
        if (parent.getChildAdapterPosition(view) %3==0) {
            outRect.left = 0;
            outRect.right = DensityUtil.dip2px(context, 7);
        }else if (parent.getChildAdapterPosition(view) %3==1) {
            outRect.left = DensityUtil.dip2px(context, 3);
            outRect.right = delta;
        }else if (parent.getChildAdapterPosition(view) %3==2) {
            outRect.left = delta;
            outRect.right = DensityUtil.dip2px(context, 3);
        }else if (parent.getChildAdapterPosition(view) %3==3) {
            outRect.left = DensityUtil.dip2px(context, 8);
            outRect.right = 0;
        }
    }

    //    private int space;
//
//    public SpaceItemDecoration(int space) {
//        this.space = space;
//    }
//
//    @Override
//    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        //不是第一个的格子都设一个左边和底部的间距
//        outRect.left = space;
//        outRect.bottom = space;
//        //由于每行都只有3个，所以第一个都是3的倍数，把左边距设为0
//        if (parent.getChildLayoutPosition(view) %3==0) {
//            outRect.left = 0;
//        }
//    }
}