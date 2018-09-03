package com.code.mvvm.core.vm;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.code.mvvm.callback.OnResultCallBack;
import com.code.mvvm.config.Constants;
import com.code.mvvm.core.data.pojo.followdraw.FollowDrawRecommendVo;
import com.code.mvvm.core.data.pojo.followdraw.FollowDrawTypeVo;
import com.code.mvvm.core.data.source.FollowDrawRepository;

/**
 * @author：tqzhang  on 18/7/31 16:05
 */
public class FollowDrawViewModel extends BaseViewModel<FollowDrawRepository> {
    public FollowDrawViewModel(@NonNull Application application) {
        super(application);
    }

    private MutableLiveData<FollowDrawTypeVo> mFollowDrawTypeData;

    private MutableLiveData<FollowDrawRecommendVo> mFollowDrawData;

    private MutableLiveData<FollowDrawRecommendVo> mFollowDrawRemData;

    public LiveData<FollowDrawTypeVo> getFollowDrawType() {
        if (mFollowDrawTypeData == null) {
            mFollowDrawTypeData = new MutableLiveData<>();
        }
        return mFollowDrawTypeData;
    }

    public LiveData<FollowDrawRecommendVo> geFollowDrawList() {
        if (mFollowDrawData == null) {
            mFollowDrawData = new MutableLiveData<>();
        }
        return mFollowDrawData;
    }

    public LiveData<FollowDrawRecommendVo> getFollowDrawRemList() {
        if (mFollowDrawRemData == null) {
            mFollowDrawRemData = new MutableLiveData<>();
        }
        return mFollowDrawRemData;
    }


    public void getFollowDrawTypeData() {
        mRepository.loadFollowDrawType(new OnResultCallBack<FollowDrawTypeVo>() {
            @Override
            public void onNoNetWork() {

            }

            @Override
            public void onNext(FollowDrawTypeVo followDrawTypeVo) {
                mFollowDrawTypeData.postValue(followDrawTypeVo);
                loadState.postValue(Constants.SUCCESS_STATE);
            }

            @Override
            public void onError(String e) {

            }
        });

    }

    public void getFollowDrawList(String maintypeid, String lastId, String rn) {
        mRepository.loadFollowDrawList(maintypeid, lastId, rn, new OnResultCallBack<FollowDrawRecommendVo>() {
            @Override
            public void onNoNetWork() {

            }

            @Override
            public void onNext(FollowDrawRecommendVo followDrawRecommendObject) {
                mFollowDrawData.postValue(followDrawRecommendObject);
                loadState.postValue(Constants.SUCCESS_STATE);
            }

            @Override
            public void onError(String e) {

            }
        });

    }

    public void getFollowDrawRemList(String lastId, String rn) {
        mRepository.loadFollowDrawRemList(lastId, rn, new OnResultCallBack<FollowDrawRecommendVo>() {
            @Override
            public void onNoNetWork() {

            }

            @Override
            public void onNext(FollowDrawRecommendVo followDrawRecommendObject) {
                mFollowDrawRemData.postValue(followDrawRecommendObject);
                loadState.postValue(Constants.SUCCESS_STATE);
            }

            @Override
            public void onError(String e) {

            }
        });

    }
}
