package com.haibin.calendarviewproject.kosmos;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.haibin.calendarviewproject.R;
import com.haibin.calendarviewproject.base.activity.BaseActivity;

public class KosmosActivity extends BaseActivity implements CalendarView.OnCalendarSelectListener,
    CalendarView.OnMonthChangeListener, CalendarView.OnYearChangeListener {
    TextView tShow;
    private FrameLayout kkkLay;
    private CalendarView calendarView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_kosmos;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
        tShow = (TextView) findViewById(R.id.showwww);
        kkkLay = (FrameLayout) findViewById(R.id.kkk_lay);
        calendarView = (CalendarView) findViewById(R.id.kkk_calendar);
    }

    @Override
    protected void initData() {
        kkkLay.setVisibility(View.GONE);
        //日期选择事件
        calendarView.setOnCalendarSelectListener(this);
        //月份改变事件
        calendarView.setOnMonthChangeListener(this);
        //年份改变事件
        calendarView.setOnYearChangeListener(this);
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.kkk_lay:
                kkkLay.setVisibility(View.GONE);
                break;
            case R.id.kkk_text://点击展示非全屏的日历
                kkkLay.setVisibility(View.VISIBLE);
                break;
            case R.id.kkk_ttt://点击打开年视图
                calendarView.showYearSelectLayout(2022);
                break;
        }
    }

    @Override
    public void onYearChange(int year) {
        tShow.setText(year + "年" + calendarView.getCurMonth() + "月" + calendarView.getCurDay() + "日");
    }

    @Override
    public void onMonthChange(int year, int month) {
        tShow.setText(year + "年" + month + "月" + calendarView.getCurDay() + "日");
    }

    @Override
    public void onCalendarOutOfRange(Calendar calendar) {

    }

    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {
        tShow.setText(calendar.getYear() + "年" + calendar.getMonth() + "月" + calendar.getDay() + "日");
    }

}
