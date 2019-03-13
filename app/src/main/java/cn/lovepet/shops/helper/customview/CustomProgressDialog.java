package cn.lovepet.shops.helper.customview;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.WindowManager;

import cn.lovepet.shops.R;

/**
 * @author JSYL-DCL
 * @date 2018/12/18 16:11
 * @des 提醒进度框
 */

public class CustomProgressDialog extends ProgressDialog {
    private boolean hasCancelable = false;
    public CustomProgressDialog(Context context) {
        super(context);
        this.hasCancelable = hasCancelable;
    }

    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
        this.hasCancelable = hasCancelable;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(getContext());
    }

    private void init(Context context) {
//        setContentView(R.layout.load_dialog);
        setContentView(R.layout.widget_dialog_progress_layout);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
    }

    /**
     * 设置不可取消，点击其他区域不能取消，实际中可以抽出去封装供外包设置
     * @param hasCancelable
     * @param hasCanceledOnTouchOutside
     */
    public void onCancel(boolean hasCancelable,boolean hasCanceledOnTouchOutside) {
        setCancelable(hasCancelable);
        setCanceledOnTouchOutside(hasCanceledOnTouchOutside);
    }

    @Override
    public void show() {
        super.show();
    }

    /**
     *  显示位置
     * @param poY 纵向偏移量
     * @param cuPos 客观位置
     */
    public void showPosition(int poY,int cuPos) {
        WindowManager.LayoutParams params = getWindow().getAttributes();
        if (cuPos == 0){
            getWindow().setGravity(Gravity.TOP);
        }else if (cuPos == 1){
            getWindow().setGravity(Gravity.BOTTOM);
        }else if (cuPos == 2){
            getWindow().setGravity(Gravity.CENTER);
        }else if (cuPos == 3){
            getWindow().setGravity(Gravity.CENTER_HORIZONTAL);
        }else if (cuPos == 4){
            getWindow().setGravity(Gravity.CENTER_VERTICAL);
        }else {
            getWindow().setGravity(Gravity.CENTER);
        }
        params.y = poY;
        getWindow().setAttributes(params);
    }
}
