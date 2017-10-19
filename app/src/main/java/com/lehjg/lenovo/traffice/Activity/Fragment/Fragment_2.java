package com.lehjg.lenovo.traffice.Activity.Fragment;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.lehjg.lenovo.traffice.Activity.util.UrlBean;
import com.lehjg.lenovo.traffice.Activity.util.Util;
import com.lehjg.lenovo.traffice.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/10/16.
 */

public class Fragment_2 extends Fragment {
    private ImageView imageViewF2Tubiao;
    private TextView textViewBuy;
    private TextView textViewF2Time1;
    private TextView textViewF2Time;
    private TextView textView88;
    private Button buttonF2;
    private TextView textViewD1;
    private TextView textViewD2;
    private TextView textViewD3;
    private TextView textViewD4;
    private ExpandableListView F2Expandable;
    Listadpter abc;
    int pus;
    int id=1;
    String key1="zhao";
    String key2="hong";
    String key3="bin";
    String key4="hh";
    List<Map<String, Object>> groupData = new ArrayList<>();//大组成员
    List<List<Map<String, Object>>> childData = new ArrayList<>();//小组成员
    UrlBean urlBean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_2,container,false);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imageViewF2Tubiao = (ImageView) getActivity().findViewById(R.id.imageView_F2_tubiao);
        textViewBuy = (TextView) getActivity().findViewById(R.id.textView_buy);
        textViewF2Time1 = (TextView) getActivity().findViewById(R.id.textView_F2_time1);
        textViewF2Time = (TextView) getActivity().findViewById(R.id.textView_F2_time_);
        textView88 = (TextView) getActivity().findViewById(R.id.textView88);
        buttonF2 = (Button) getActivity().findViewById(R.id.button_F2);
        buttonF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setTitle("详情");
                dialog.getWindow().setContentView(R.layout.car_recharge);
                dialog.show();
            }
        });
        F2Expandable = (ExpandableListView) getActivity().findViewById(R.id.F2_Expandable);
        textViewD1 = (TextView) getActivity().findViewById(R.id.textView_D1);
        textViewD2 = (TextView) getActivity().findViewById(R.id.textView_D2);
        textViewD3 = (TextView) getActivity().findViewById(R.id.textView_D3);
        textViewD4 = (TextView) getActivity().findViewById(R.id.textView_D4);
        urlBean = Util.loadSetting(getContext());
        String urlHost = "http://" + urlBean.getUrl()+":"+urlBean.getPort()
                +"/transportservice/type/jason/action/GetBusStationInfo.do";
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("BusStationId",id);
        }catch (JSONException e) {
            e.printStackTrace();
        }
        pus = 1;
        getAllCarValue(urlHost,jsonObject);
    }
    class Listadpter extends BaseExpandableListAdapter{
        Context context;
        public Listadpter(Context context) {
            super();
            this.context = context;
        }
        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewgroup) {
            if (view == null) {
                LayoutInflater inflater = LayoutInflater.from(getActivity());
                view = inflater.inflate(R.layout.list_f2_groud, null);
            }
            ImageView imageViewListGount = (ImageView) view.findViewById(R.id.imageView_List_gount);
            TextView textViewListGount = (TextView) view.findViewById(R.id.textView_List_gount);
            textViewListGount.setText(getGroup(i).toString());
            imageViewListGount.setImageResource(R.drawable.jia);
            if(b){
                imageViewListGount.setImageResource(R.drawable.jian);
            }else{
                imageViewListGount.setImageResource(R.drawable.jia);
            }
            return view;
        }
        @Override
        public int getGroupCount() {
            return groupData.size();
        }

        @Override
        public int getChildrenCount(int i) {
            return childData.get(i).size();
        }

        @Override
        public Object getGroup(int i) {
            return groupData.get(i).get(key1).toString();
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return null;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return 0;
        }

        @Override
        public long getChildId(int i, int i1) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }



        @Override
        public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewgroup) {
            if (view == null){
                LayoutInflater inflater = LayoutInflater.from(getActivity());
                view = inflater.inflate(R.layout.list_f2_son,null);
            }
            ImageView imageView4 = (ImageView) view.findViewById(R.id.imageView4);
            TextView textViewListSon1 = (TextView) view.findViewById(R.id.textView_list_son1);
            TextView textViewListSon2 = (TextView) view.findViewById(R.id.textView_list_son2);
            TextView textViewListSon3 = (TextView) view.findViewById(R.id.textView_list_son3);
            textViewListSon1.setText(childData.get(i).get(i1).get(key2).toString());
            textViewListSon1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (i){
                        case 0:
                            switch (i1){
                                case 0:
                                    Toast.makeText(getActivity(),"1,1", Toast.LENGTH_SHORT).show();break;
                                case 1:
                                    Toast.makeText(getActivity(),"1,2", Toast.LENGTH_SHORT).show();break;
                                case 2:
                                    Toast.makeText(getActivity(),"1,3", Toast.LENGTH_SHORT).show();break;}
                            break;
                        case 1:switch (i1){case 0:
                            Toast.makeText(getActivity(),"2,1", Toast.LENGTH_SHORT).show();break;
                            case 1:
                                Toast.makeText(getActivity(),"2,2", Toast.LENGTH_SHORT).show();break;
                            case 2:
                                Toast.makeText(getActivity(),"2,3", Toast.LENGTH_SHORT).show();break;}
                            break;}
                }
            });
            textViewListSon2.setText(childData.get(i).get(i1).get(key3).toString());
            textViewListSon3.setText(childData.get(i).get(i1).get(key4).toString());
            imageView4.setImageResource(R.drawable.home);
            return view;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }
    }

    private void getAllCarValue(String urlHostAction, JSONObject params) {
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.
                Method.POST, urlHostAction, params, new Response.Listener<JSONObject>() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onResponse(JSONObject response) {
                String str = response.optString("serverinfo");
                if (pus==1){
                    try {
                        JSONArray abc = new JSONArray(str);
                        JSONObject abcd = abc.getJSONObject(0);
                        String ab = abcd.getString("Distance");
                        textViewD1.setText(ab);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        JSONArray abc = new JSONArray(str);
                        JSONObject abcd = abc.getJSONObject(1);
                        String ab = abcd.getString("Distance");
                        textViewD2.setText(ab);
                        car();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }else if (pus==2){
                    try {
                        JSONArray abc = new JSONArray(str);
                        JSONObject abcd = abc.getJSONObject(0);
                        String ab = abcd.getString("Distance");
                        textViewD3.setText(ab);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        JSONArray abc = new JSONArray(str);
                        JSONObject abcd = abc.getJSONObject(1);
                        String ab = abcd.getString("Distance");
                        textViewD4.setText(ab);
                        drt();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }


        }, new Response.ErrorListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getContext(),"失败",Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);
        }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private void car() {
        urlBean = Util.loadSetting(getContext());
        String urlHost = "http://"+urlBean.getUrl()+":"
                +urlBean.getPort()+
                "/transportservice/type/jason/action/GetBusStationInfo.do";
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("BusStationId",2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        pus = 2;
        getAllCarValue(urlHost, jsonObject);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void drt() {
        int d1= Integer.parseInt(textViewD1.getText().toString());
        int d2= Integer.parseInt(textViewD2.getText().toString());
        int d3= Integer.parseInt(textViewD3.getText().toString());
        int d4= Integer.parseInt(textViewD4.getText().toString());
        int dd;
        if (d1>d2){
            dd=d1;
            d1=d2;
            d2=dd;
        }
        float t1 = d1/(2000/60);
        float t2 = d2/(2000/60);
        float t3 = d3/(2000/60);
        float t4 = d4/(2000/60);
        Map<String,Object> gound = new HashMap<>();
        gound.put(key1,"中医医院");
        groupData.add(gound);
        List<Map<String,Object>> son = new ArrayList<>();
        if (d2>d1){
            Map<String,Object> gound1 = new HashMap<>();
            gound1.put(key2,"1号(101)人");
            gound1.put(key3,t1+"分钟");
            gound1.put(key4,"距离"+d1+"m");
            son.add(gound1);
            gound1 = new HashMap<>();
            gound1.put(key2,"2号(101)人");
            gound1.put(key3,t2+"分钟");
            gound1.put(key4,"距离"+d2+"m");
            son.add(gound1);
        }else{
            Map<String,Object> goundl = new HashMap<>();
            goundl.put(key2,"2号（101）人");
            goundl.put(key3,t2+"分钟");
            goundl.put(key4,"距离"+d2+"m");
            son.add(goundl);
            goundl = new HashMap<>();
            goundl.put(key2,"1号（101）人");
            goundl.put(key3,t1+"分钟");
            goundl.put(key4,"距离"+d1+"m");
            son.add(goundl);
        }
        childData.add(son);
        gound = new HashMap<>();
        gound.put(key1,"联想大厦站");
        groupData.add(gound);
        son = new ArrayList<>();
        if(d3<d4){
            Map<String,Object> goundl = new HashMap<>();
            goundl.put(key2,"1号（101）人");
            goundl.put(key3,t3+"分钟");
            goundl.put(key4,"距离"+d3+"m");
            son.add(goundl);
            goundl = new HashMap<>();
            goundl.put(key2,"2号（101）人");
            goundl.put(key3,t4+"分钟");
            goundl.put(key4,"距离"+d4+"m");
            son.add(goundl);

        }else{
            Map<String,Object> goundl = new HashMap<>();
            goundl.put(key2,"2号（101）人");
            goundl.put(key3,t4+"分钟");
            goundl.put(key4,"距离"+d4+"m");
            son.add(goundl);
            goundl = new HashMap<>();
            goundl.put(key2,"1号（101）人");
            goundl.put(key3,t3+"分钟");
            goundl.put(key4,"距离"+d3+"m");
            son.add(goundl);
        }
        childData.add(son);
        abc = new Listadpter(getContext());
        F2Expandable.setAdapter(abc);
        F2Expandable.setChildIndicator(null);
        F2Expandable.setDivider(null);
    }

}
