package www.zhouyan.project.widget.viewpager;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @author zhouyan 禁止左右滑动的viewpager
 */
public class NoSlideViewPager extends ViewPager {

	private boolean isScrollable = false;

	public NoSlideViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public NoSlideViewPager(Context context) {
		super(context);
	}

	public NoSlideViewPager(Context context, @Nullable AttributeSet attrs, int defStyle) {
		this(context, attrs);
	}
	public void setNoScroll(boolean isScrollable) {
		this.isScrollable = isScrollable;
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if (isScrollable == false) {
			return false;
		} else {
			return super.onTouchEvent(ev);
		}

	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if (isScrollable == false) {
			return false;
		} else {
			return super.onInterceptTouchEvent(ev);
		}

	}
	
}
