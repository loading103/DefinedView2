package udesk.sdk.definedview.view;

import android.content.Context;
import android.graphics.Point;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/9/17.
 */
public class DragLayout extends LinearLayout {

    private String TAG = "DragLayout";

    private ViewDragHelper dragHelper;

    private TextView textView1, textView2, textView3;
    private FloatingActionButton button,button1;

    private Point viewPos = new Point();
    private Point viewPos1 = new Point();
    public DragLayout(Context context) {
        super(context);
        initView();
    }

    public DragLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        textView1 = (TextView) getChildAt(0);
        textView2 = (TextView) getChildAt(1);
        textView3 = (TextView) getChildAt(2);
        button= (FloatingActionButton) getChildAt(3);
        button1= (FloatingActionButton) getChildAt(4);
        viewPos.x = (int) textView1.getX();
        viewPos.y = (int) textView1.getY();
        viewPos1.x = (int) button1.getX();
        viewPos1.y = (int) button1.getY();
    }

    private void initView() {
        dragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                Log.e(TAG, "tryCaptureView pointerId=" + pointerId);
                if (child == textView1 || child == textView2 ||child==button||child==button1) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public void onViewDragStateChanged(int state) {
                super.onViewDragStateChanged(state);
                Log.e(TAG, "onViewDragStateChanged state=" + state);
            }

            @Override
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                super.onViewPositionChanged(changedView, left, top, dx, dy);
                Log.e(TAG, "onViewPositionChanged left=" + left + " top=" + top + " dx=" + dx + " dy=" + dy);
            }

            @Override
            public void onViewCaptured(View capturedChild, int activePointerId) {
                super.onViewCaptured(capturedChild, activePointerId);
                Log.e(TAG, "onViewCaptured activePointerId=" + activePointerId);
            }

            @Override
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                super.onViewReleased(releasedChild, xvel, yvel);
                Log.e(TAG, "onViewReleased" + " xvel=" + xvel + " yvel=" + yvel);
                if (releasedChild == textView1) {
                    dragHelper.settleCapturedViewAt(viewPos.x, viewPos.y);
                    invalidate();
                }else if(releasedChild==button1){
                    dragHelper.settleCapturedViewAt(viewPos1.x, viewPos1.y);
                    invalidate();
                }
            }

            @Override
            public void onEdgeTouched(int edgeFlags, int pointerId) {
                super.onEdgeTouched(edgeFlags, pointerId);
                Log.e(TAG, "onEdgeTouched pointerId=" + pointerId);
            }

            @Override
            public boolean onEdgeLock(int edgeFlags) {
                Log.e(TAG, "onEdgeLock edgeFlags=" + edgeFlags);
                return super.onEdgeLock(edgeFlags);
            }

            @Override
            public void onEdgeDragStarted(int edgeFlags, int pointerId) {
                super.onEdgeDragStarted(edgeFlags, pointerId);
                Log.e(TAG, "onEdgeDragStarted pointerId=" + pointerId);
                dragHelper.captureChildView(textView3, pointerId);
            }

            @Override
            public int getOrderedChildIndex(int index) {
                Log.e(TAG, "getOrderedChildIndex index=" + index);
                return super.getOrderedChildIndex(index);
            }

            @Override
            public int getViewHorizontalDragRange(View child) {
                Log.e(TAG, "getViewHorizontalDragRange");
                return super.getViewHorizontalDragRange(child);
            }

            @Override
            public int getViewVerticalDragRange(View child) {
                Log.e(TAG, "getViewVerticalDragRange");
                return super.getViewVerticalDragRange(child);
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {

                final int leftBound = getPaddingLeft();
                final int rightBound = getWidth() - child.getWidth() - leftBound;
                if (left < leftBound) {
                    left = leftBound;
                }
                if (left > rightBound) {
                    left = rightBound;
                }

                final int newLeft = Math.min(Math.max(left, leftBound), rightBound);

                Log.e(TAG, "clampViewPositionHorizontal left=" + left);
                Log.e(TAG, "clampViewPositionHorizontal leftBound=" + leftBound);
                Log.e(TAG, "clampViewPositionHorizontal rightBound=" + rightBound);
                Log.e(TAG, "clampViewPositionHorizontal newLeft=" + newLeft);
                return left;
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                Log.e(TAG, "clampViewPositionVertical" + " top=" + top + " dy=" + dy);
                int topBound = getPaddingTop();
                if (top < topBound) {
                    top = topBound;
                }

                return top;
            }
        });
        dragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_LEFT);

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return dragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        dragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (dragHelper.continueSettling(true)) {
            invalidate();
        }
    }
}
