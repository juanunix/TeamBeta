package com.limox.jesus.monksresurrection.Fragments.GenericPosts;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.limox.jesus.monksresurrection.Adapters.PostAdapterRecycler;
import com.limox.jesus.monksresurrection.Model.Post;
import com.limox.jesus.monksresurrection.R;
import com.limox.jesus.monksresurrection.Utils.AllConstants;

import java.util.ArrayList;

public class DashPost_Fragment extends Fragment {

   // private OnDashPostFragmentListener mCallback;
    private ArrayList<Post> mPostList;
    private PostAdapterRecycler mAdapter;
    private RecyclerView rvList;
    private static DashPost_Fragment fragment;

   /* public interface OnDashPostFragmentListener{

    }*/


    public static DashPost_Fragment newInstance(Bundle postList) {
        if (fragment == null)
            fragment = new DashPost_Fragment();
        fragment.setArguments(postList);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPostList = getArguments().getParcelableArrayList(AllConstants.ARRAYLIST_POST_PARCELABLE_KEY);
            mAdapter = new PostAdapterRecycler(getContext(),getArguments().getInt(AllConstants.TYPELIST_KEY,AllConstants.FOR_PUBLISHED));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_dash_post, container, false);
        rvList = (RecyclerView) rootView.findViewById(R.id.dp_rvList);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvList.setAdapter(mAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       /* if (context instanceof OnDashPostFragmentListener) {
            mCallback = (OnDashPostFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mCallback = null;
    }


}