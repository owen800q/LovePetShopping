package cn.lovepet.shops.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import cn.lovepet.shops.R;
import cn.lovepet.shops.view.ui.activity.home.PetTypeSwitchActivity;

/**
 * @author JSYL-DCL
 * @date 2018/10/18 10:21
 * @des
 */
public class EpetTypeSwitchView extends RelativeLayout {
    MyImageView a;
    MyImageView b;
    LinearLayout c;
    Context d;

    public EpetTypeSwitchView(Context paramContext) {
        super(paramContext);
        init(paramContext);
    }

    public EpetTypeSwitchView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramContext);
    }

    public EpetTypeSwitchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init(paramContext);
    }

    private void init(final Context context) {
        View inflate;
        inflate = LayoutInflater.from(context).inflate(R.layout.view_epettype_switch, this, true);
        MyImageView viewById = (MyImageView) inflate.findViewById(R.id.epet_prompt);
        MyImageView imageViewDog = (MyImageView) inflate.findViewById(R.id.epet_type);
        LinearLayout switchlayout = (LinearLayout) inflate.findViewById(R.id.layout);
        //设置动画背景
        //其中R.drawable.animation_list就是上一步准备的动画描述文件的资源名
        imageViewDog.setBackgroundResource(R.drawable.anim_tab_home_switch);
        //获得动画对象
        //不一定是设置背景，也可以作为src图片设置
        AnimationDrawable animaition = (AnimationDrawable) imageViewDog.getBackground();
        animaition.setOneShot(false);
        animaition.start();
        switchlayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent localIntent = new Intent(context, PetTypeSwitchActivity.class);
                context.startActivity(localIntent);
//                context.overridePendingTransition(R.anim.fade_in, 0);
            }
//            private static final a.a c;
//
//
//            private static void a()
//            {
//                b localb = new b("EpetTypeSwitchView.java", 1.class);
//                c = localb.a("method-execution", localb.a("1", "onClick", "com.epet.android.app.widget.EpetTypeSwitchView$1", "android.view.View", "view", "", "void"), 59);
//            }
//
//            public void onClick(View paramAnonymousView)
//            {
//                paramAnonymousView = b.a(c, this, this, paramAnonymousView);
//                try
//                {
//                    if (con.getTag() == null)
//                    {
//                        Intent localIntent = new Intent(TabActivity.instance, EpetTypeSwitchActivity.class);
//                        EpetTypeSwitchView.this.d.startActivity(localIntent);
//                        TabActivity.instance.overridePendingTransition(2130771986, 0);
//                    }
//                    ViewOnClickListenerAspectj.aspectOf().onViewClickAOP(paramAnonymousView);
//                    return;
//                }
//                catch (Throwable localThrowable)
//                {
//                    ViewOnClickListenerAspectj.aspectOf().onViewClickAOP(paramAnonymousView);
//                    throw localThrowable;
//                }
//            }
        });
    }

    public void a()
    {
//        if ("cat".equals(c.g))
//        {
//            this.a.setImageDrawable(getResources().getDrawable(2131231155));
//            this.b.setBackgroundDrawable(getResources().getDrawable(2131231175));
//        }
//        for (;;)
//        {
//            ((AnimationDrawable)this.b.getBackground()).start();
//            return;
//            if ("dog".equals(c.g))
//            {
//                this.a.setImageDrawable(getResources().getDrawable(2131231156));
//                this.b.setBackgroundDrawable(getResources().getDrawable(2131231176));
//            }
//            else if ("fish".equals(c.g))
//            {
//                this.a.setImageDrawable(getResources().getDrawable(2131231157));
//                this.b.setBackgroundDrawable(getResources().getDrawable(2131231177));
//            }
//        }
    }

    public LinearLayout get_layout()
    {
        return this.c;
    }
}
