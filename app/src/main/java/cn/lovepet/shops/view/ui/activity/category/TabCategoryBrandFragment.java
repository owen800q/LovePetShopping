package cn.lovepet.shops.view.ui.activity.category;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.library.BaseMultiItemQuickAdapter;
import com.github.library.BaseQuickAdapter;
import com.github.library.BaseViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.lovepet.shops.R;
import cn.lovepet.shops.base.BaseFragment;
import cn.lovepet.shops.bean.PetCategoryBrand;
import cn.lovepet.shops.util.FileUtils;
import cn.lovepet.shops.util.ILog;

/**
 * @author JSYL-DCL
 * @date 2018/10/29 10:50
 * @des 分类-品牌
 */
public class TabCategoryBrandFragment extends BaseFragment {
    private static final java.lang.String TAG1 = TabCategoryBrandFragment.class.getSimpleName();
    @BindView(R.id.brandsRecyclerView)
    RecyclerView mRecyclerView;
    private List<PetCategoryBrand.Brand> brandList;
    private BaseQuickAdapter mBrandAdapter;
    @Override
    protected int setImmersiveStatusBarColor() {
        return 0;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_category_brand;
    }

    @Override
    protected void init() {
        if (brandList != null)brandList.clear();
        else brandList = new ArrayList<>();
    }

    @Override
    protected void bindView() {
//        getBrandData();
        setBrandAll();
    }

    @Override
    protected void bindData(Bundle savedInstanceState) {

    }

    @Override
    protected void bindListener() {

    }


    private void getBrandData() {
        String json = FileUtils.getJson(getActivity(), "pet_dog_category_brand.json");
        Gson gson = new Gson();
        Type type = new TypeToken<PetCategoryBrand>() {}.getType();
        PetCategoryBrand petCategoryBrand = gson.fromJson(json, type);
        List<PetCategoryBrand.Brand> brand = petCategoryBrand.getBrand();
        ILog.e(TAG1,"brand---------->>:"+new Gson().toJson(brand));
        brandList.addAll(brand);
        long sys_time = petCategoryBrand.getSys_time();
        mBrandAdapter.notifyDataSetChanged();

    }

    private void setBrandAll() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setItemViewCacheSize(10);
        mBrandAdapter = new BrandAdapter(brandList);
        //防止数据错乱
        mBrandAdapter.setHasStableIds(true);
        mRecyclerView.setAdapter(mBrandAdapter);
        getBrandData();
    }



    private BaseQuickAdapter mBrandGridAdaper;
    public class BrandAdapter extends BaseMultiItemQuickAdapter<PetCategoryBrand.Brand, BaseViewHolder> {
        /**
         * Same as QuickAdapter#QuickAdapter(Context,int) but with
         * some initialization data.
         *
         * @param data A new list is created out of this one to avoid mutable list
         */
        public BrandAdapter(List<PetCategoryBrand.Brand> data) {
            super(data);
            addItemType(PetCategoryBrand.Brand.CATEGORY_BRAND_GRID, R.layout.item_dog_category_brand_grid);
        }

        @Override
        protected void convert(BaseViewHolder holder, PetCategoryBrand.Brand data) {
            final int adapterPosition = holder.getAdapterPosition();
            switch (data.getItemType()) {
                case 1://普通商品
                    TextView tvTitleName = (TextView) holder.getView(R.id.tvTitleName);
                    RecyclerView mBrandGridRecyclerView = (RecyclerView) holder.getView(R.id.brandGridRecyclerView);
                    tvTitleName.setText(data.getTitle() == null ? "" : data.getTitle());
                    List<PetCategoryBrand.Brand.Blist> blist = data.getBlist();
                    mBrandGridRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
                    mBrandGridRecyclerView.setHasFixedSize(true);
                    mBrandGridRecyclerView.setItemViewCacheSize(10);
                    mBrandGridRecyclerView.setAdapter(mBrandGridAdaper = new BaseQuickAdapter<PetCategoryBrand.Brand.Blist, BaseViewHolder>(R.layout.item_dog_category_brand_grid_item, blist) {
                        @Override
                        protected void convert(BaseViewHolder helper, PetCategoryBrand.Brand.Blist item) {
                            int adapterPosition = helper.getAdapterPosition();
                            TextView brandGridName = (TextView) helper.getView(R.id.brandGridName);
                            TextView brandArea = (TextView) helper.getView(R.id.brandArea);
                            brandGridName.setText(item.getName() == null? "" : item.getName());
                            brandArea.setText(item.getAddress() == null? "" : item.getAddress());
                            ImageView brandCenterImage = (ImageView) helper.getView(R.id.brandCenterImage);
                            Glide.with(mContext)
                                    .load(item.getLogo())
                                    .asBitmap()
                                    .skipMemoryCache(false)
                                    .priority(Priority.HIGH)
                                    .dontTransform()
                                    .placeholder(R.mipmap.pet_image_loadding)
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(brandCenterImage);

                        }
                    });

                    break;
                default:
                    break;

            }
        }
    }


}