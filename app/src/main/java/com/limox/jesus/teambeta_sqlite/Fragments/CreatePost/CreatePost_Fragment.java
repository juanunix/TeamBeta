package com.limox.jesus.teambeta_sqlite.Fragments.CreatePost;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.limox.jesus.teambeta_sqlite.Interfaces.PostManagerPresenter;
import com.limox.jesus.teambeta_sqlite.Model.Post;
import com.limox.jesus.teambeta_sqlite.Notifications.Notifications;
import com.limox.jesus.teambeta_sqlite.Presenter.PostManagerPresenterImpl;
import com.limox.jesus.teambeta_sqlite.R;
import com.limox.jesus.teambeta_sqlite.Repositories.Users_Repository;


public class CreatePost_Fragment extends Fragment implements PostManagerPresenter.View {

    private EditText mEdtTitle;
    private EditText mEdtDescription;
    private EditText mEdtTags;
    private String mTitle;
    private String mDescriptions;
    private Toolbar mToolbar;
    private String mTags;
    private RelativeLayout mRlContainer;
    private OnCreatePostFragmentListener mCallback;
    private Toolbar.OnMenuItemClickListener mMenuItemListener;
    private PostManagerPresenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PostManagerPresenterImpl(this);
        /*setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(getString(com.limox.jesus.teambeta_sqlite.R.string.create_post));
        getSupportActionBar().setHomeAsUpIndicator(com.limox.jesus.teambeta_sqlite.R.drawable.ic_action_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_create_post, container, false);
        mEdtTitle = (EditText) rootView.findViewById(com.limox.jesus.teambeta_sqlite.R.id.crp_EdtPostTitle);
        mEdtDescription = (EditText) rootView.findViewById(com.limox.jesus.teambeta_sqlite.R.id.crp_EdtPostDescription);
        mEdtTags = (EditText) rootView.findViewById(com.limox.jesus.teambeta_sqlite.R.id.crp_EdtPostTags);
        mToolbar = (Toolbar) rootView.findViewById(com.limox.jesus.teambeta_sqlite.R.id.acp_toolbar);
        mRlContainer = (RelativeLayout) rootView.findViewById(com.limox.jesus.teambeta_sqlite.R.id.activity_create_post);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar.inflateMenu(R.menu.menu_create_post);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.action_send:
                        sendPost();
                        break;

                    case android.R.id.home:
                        getActivity().onBackPressed();
                        break;
                }
                return true;
            }
        });


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCreatePostFragmentListener) {
            mCallback = (OnCreatePostFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAddTagsFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    public interface OnCreatePostFragmentListener {

    }
    private boolean validate() {
        boolean allRigth = false;

        mTitle = mEdtTitle.getText().toString();
        mDescriptions= mEdtDescription.getText().toString();
        mTags = mEdtTags.getText().toString();

        if (mTitle.length() > 0 && mDescriptions.length() > 0 && mTags.length() > 0)
            allRigth = true;
        return allRigth;
    }



    private void sendPost() {
        if (validate()){
            mPresenter.uploadPost(new Post(Users_Repository.get().getCurrentUser().getIdUser(),mTitle,mDescriptions,mTags));
            //Posts_Repository.get().createPost(mTitle,mDescriptions,mTags);
            Notifications.SentPublicationPostSended(getContext());
            getActivity().onBackPressed();
        }else
            Snackbar.make(mRlContainer, com.limox.jesus.teambeta_sqlite.R.string.message_error_must_fill,Snackbar.LENGTH_LONG).show();

    }

    private void initMenuItemListener(){
        mMenuItemListener = new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_send:
                        sendPost();
                        break;
                }
                return true;
            }
        };
    }
}
