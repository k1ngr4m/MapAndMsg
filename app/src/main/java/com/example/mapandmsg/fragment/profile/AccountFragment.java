package com.example.mapandmsg.fragment.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mapandmsg.R;
import com.example.mapandmsg.core.BaseFragment;
import com.example.mapandmsg.fragment.CallBack;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xui.widget.textview.supertextview.SuperTextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.leancloud.AVUser;

/**
 * 账号页面
 * @author 夕子
 */
@Page(name = "账号")
public class AccountFragment extends BaseFragment implements
        SuperTextView.OnSuperTextViewClickListener, CallBack.OnBackUpDataUserNameListener {
    @BindView(R.id.menu_username)
    SuperTextView menuUserName;
    @BindView(R.id.menu_password)
    SuperTextView menuPassword;
    @BindView(R.id.menu_phone)
    SuperTextView menuPhone;
    @BindView(R.id.menu_email)
    SuperTextView menuEmail;
    @BindView(R.id.menu_signature)
    SuperTextView menuSignature;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_account;
    }

    @Override
    protected View inflateView(LayoutInflater inflater, ViewGroup container) {
        return null;
    }

    @Override
    protected void initViews() {
        CallBack.getInstance().setOnBackUpDataUserNameListener(this);
        upData();
    }

    private void upData() {
        AVUser user = AVUser.getCurrentUser();
        menuUserName.setRightBottomString(user.get("username") == null ? "未设置"
                : user.get("username").toString());
        menuPhone.setRightBottomString(user.get("mobilePhoneNumber") == null ? "未绑定"
                : user.get("mobilePhoneNumber").toString());
        menuEmail.setRightBottomString(user.get("email") == null ? "未绑定"
                : user.get("email").toString());
        menuSignature.setRightBottomString(user.get("signature") == null ? "未设置"
                : user.get("signature").toString());
    }


    @Override
    @OnClick({R.id.menu_username,R.id.menu_signature})
    public void onClick(SuperTextView superTextView) {
        switch (superTextView.getId()){
            case R.id.menu_username:
                openNewPage(ModifyNameFragment.class);
                break;
            case R.id.menu_signature:
                openNewPage(ModifySignatureFragment.class);
            default:
                break;
        }
    }

    @Override
    public void onBackUpDataUserName() {
        upData();
    }
}