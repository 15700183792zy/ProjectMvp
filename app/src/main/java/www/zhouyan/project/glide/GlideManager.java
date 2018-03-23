package www.zhouyan.project.glide;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;

import www.zhouyan.project.R;
import www.zhouyan.project.app.MyApplication;

/**
 * @author zhouyan
 */
public class GlideManager {

	/*

	.fitCenter()//图片显示全部 但是imageview可能填充不全
	.centerCrop()//填充全部imageview 但是图片显示不全
	.thumbnail( 0.3f )//缩略图

	自定义动画
	 ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
	    @Override
	    public void animate(View view) {
	        // if it's a custom view class, cast it here
	        // then find subviews and do the animations
	        // here, we just use the entire view for the fade animation
	        view.setAlpha( 0f );

	        ObjectAnimator fadeAnim = ObjectAnimator.ofFloat( view, "alpha", 0f, 1f );
	        fadeAnim.setDuration( 2500 );
	        fadeAnim.start();
	    }
	};
	*/

    /**
     * 渐显动画时间 ms
     */
    private static final int duration = 100;
    private static final int placeholder= R.drawable.img_placeholder;//占位图
    private static final int header_placeholder= R.drawable.img_placeholder;//圆形头像占位图
    private static final int error= R.drawable.img_default;//加载失败图R.drawable.img_default


    /**
     * 使用bitmap回调 指定大小加载
     *
     * @param context
     * @param url
     * @param iv
     */
    public static void getBitmap(Activity context, String url, final ImageView iv, int width, int height) {
        Glide.with(context) // could be an issue!
                .load(url)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>(width, height) {
                    @Override
                    public void onResourceReady(Bitmap bitmap, @SuppressWarnings("rawtypes") GlideAnimation glideAnimation) {
                        // do something with the bitmap
                        // for demonstration purposes, let's just set it to an ImageView
                        iv.setImageBitmap(bitmap);
                    }
                });
    }

    /**
     * 加载网络图片 圆形
     *
     * @param context
     * @param url
     * @param iv
     */
    public static void setRoundImage(final Activity context, String url, final ImageView iv) {
        ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {
                // if it's a custom view class, cast it here
                // then find subviews and do the animations
                // here, we just use the entire view for the fade animation
                view.setAlpha(0f);

                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
                fadeAnim.setDuration(duration);
                fadeAnim.start();
            }
        };

        Glide.with(context).load(url).asBitmap().centerCrop()
                .placeholder(placeholder)
                .error(error)
                .animate(animationObject)
                .into(new BitmapImageViewTarget(iv) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        Bitmap dst;
                        //将长方形图片裁剪成正方形图片
                        if (resource.getWidth() >= resource.getHeight()) {
                            dst = Bitmap.createBitmap(resource, resource.getWidth() / 2 - resource.getHeight() / 2, 0, resource.getHeight(), resource.getHeight()
                            );
                        } else {
                            dst = Bitmap.createBitmap(resource, 0, resource.getHeight() / 2 - resource.getWidth() / 2, resource.getWidth(), resource.getWidth()
                            );
                        }
                        circularBitmapDrawable.setCornerRadius(dst.getWidth() / 2); //设置圆角半径为正方形边长的一半
                        circularBitmapDrawable.setAntiAlias(true);

                        iv.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    /**
     * 加载本地图片 圆形
     *
     * @param context
     * @param resId
     * @param iv
     */
    public static void setRoundImage(final Activity context, int resId, final ImageView iv) {
        ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {
                // if it's a custom view class, cast it here
                // then find subviews and do the animations
                // here, we just use the entire view for the fade animation
                view.setAlpha(0f);

                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
                fadeAnim.setDuration(duration);
                fadeAnim.start();
            }
        };

        Glide.with(context).load(resId).asBitmap().centerCrop()
                .placeholder(placeholder)
                .error(error)
                .animate(animationObject)
                .into(new BitmapImageViewTarget(iv) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        Bitmap dst;
                        //将长方形图片裁剪成正方形图片
                        if (resource.getWidth() >= resource.getHeight()) {
                            dst = Bitmap.createBitmap(resource, resource.getWidth() / 2 - resource.getHeight() / 2, 0, resource.getHeight(), resource.getHeight()
                            );
                        } else {
                            dst = Bitmap.createBitmap(resource, 0, resource.getHeight() / 2 - resource.getWidth() / 2, resource.getWidth(), resource.getWidth()
                            );
                        }
                        circularBitmapDrawable.setCornerRadius(dst.getWidth() / 2); //设置圆角半径为正方形边长的一半
                        circularBitmapDrawable.setAntiAlias(true);

                        iv.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    /**
     * 加载本地图片 椭圆形
     *
     * @param context
     * @param resId
     * @param iv
     */
  /*  public static void setRoundImage(final Activity context, int resId, final ImageView iv) {
        ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {
                // if it's a custom view class, cast it here
                // then find subviews and do the animations
                // here, we just use the entire view for the fade animation
                view.setAlpha(0f);

                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
                fadeAnim.setDuration(duration);
                fadeAnim.start();
            }
        };

        Glide.with(context).load(resId).asBitmap().centerCrop()
                .placeholder(placeholder)
                .error(error)
                .animate(animationObject)
                .into(new BitmapImageViewTarget(iv) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        Bitmap dst;
                        //将长方形图片裁剪成正方形图片
                        if (resource.getWidth() >= resource.getHeight()) {
                            dst = Bitmap.createBitmap(resource, resource.getWidth() / 2 - resource.getHeight() / 2, 0, resource.getHeight(), resource.getHeight()
                            );
                        } else {
                            dst = Bitmap.createBitmap(resource, 0, resource.getHeight() / 2 - resource.getWidth() / 2, resource.getWidth(), resource.getWidth()
                            );
                        }
                        circularBitmapDrawable.setCornerRadius(dst.getWidth() / 2); //设置圆角半径为正方形边长的一半
                        circularBitmapDrawable.setAntiAlias(true);

                        iv.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }*/

    /**
     * 加载网络图片
     *
     * @param context
     * @param url
     * @param iv
     */
    public static void setNormalImage(Activity context, String url, ImageView iv) {
        setNormalImage(url,iv);
    }

    /**
     * 加载网络图片

     * @param url
     * @param iv
     */
    public static void setNormalImage(String url, ImageView iv) {

        Glide.with(MyApplication.getInstance().getMyApplication())
                .load(url)
                .placeholder(placeholder)//加载之前的 默认占位图
                .error(error)//图片无法加载时的 默认占位图
                .crossFade(duration)//淡入淡出动画 默认100ms
                .centerCrop()
                .into(iv);
    }

    /**
     * 加载圆角本地网络图片

     * @param url
     * @param iv
     */
    public static void setNormalImageCircle(String url,final  ImageView iv) {
//        Context mcontext = MyApplication.getInstance().getMyApplication();
//        Glide.with(mcontext).load(url).asBitmap()
//                .placeholder(placeholder)
//                .error(error)
//                .transform(new GlideCircleTransform(mcontext))
//                .into(iv);

        final Context context = MyApplication.getInstance().getMyApplication();
        Glide.with(context).load(url).asBitmap()
                .placeholder(placeholder)
                .error(error)
                .into(new BitmapImageViewTarget(iv) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(5); //设置圆角度数
                        circularBitmapDrawable.setAntiAlias(true);

                        iv.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    /**
     * 加载圆角本地图片

     * @param url
     * @param iv
     */
    public static void setNormalImageCircle(int url,final  ImageView iv) {
        final Context context = MyApplication.getInstance().getMyApplication();
        Glide.with(context).load(url).asBitmap()
                .placeholder(placeholder)
                .error(error)
                .into(new BitmapImageViewTarget(iv) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(5); //设置圆角度数
                        circularBitmapDrawable.setAntiAlias(true);

                        iv.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }


    /**
     * 加载网络图片 自定义动画
     *
     * @param context
     * @param url
     * @param iv
     */
    public static void setNormalImage(Activity context, String url, ImageView iv, int animId) {
        Glide.with(MyApplication.getInstance().getMyApplication())
                .load(url)
                .placeholder(placeholder)//加载之前的 默认占位图
                .error(error)//图片无法加载时的 默认占位图
                .animate(animId)
                .centerCrop()
                .into(iv);
    }

    /**
     * 加载本地图片
     *
     * @param context
     * @param resId
     * @param iv
     */
    public static void setNormalImage(Activity context, int resId, ImageView iv) {
        setNormalImage(resId,iv);
//        Glide.with(MyApplication.getInstance().getMyApplication())
//                .load(resId)
////                .placeholder(placeholder)//加载之前的 默认占位图
////                .error(error)//图片无法加载时的 默认占位图
//                .crossFade(duration)//淡入淡出动画 默认100ms
//                .centerCrop()
//                .into(iv);

    }

    /**
     * 加载本地图片 自定义动画
     * @param iv
     */
    public static void setNormalImageLancher(int resId, ImageView iv) {
        Glide.with(MyApplication.getInstance().getMyApplication())
                .load(resId)
               /* .placeholder(R.drawable.lanucher_first)//加载之前的 默认占位图
                .error(R.drawable.lanucher_first)//图片无法加载时的 默认占位图*/
                .crossFade(100)//淡入淡出动画 默认100ms
                .centerCrop()
                .into(iv);
    }
    /**
     * 加载本地图片 自定义动画
     * @param iv
     */
    public static void setNormalImage(int resId, ImageView iv) {
        Glide.with(MyApplication.getInstance().getMyApplication())
                .load(resId)
                .placeholder(placeholder)//加载之前的 默认占位图
                .error(error)//图片无法加载时的 默认占位图
                .crossFade(duration)//淡入淡出动画 默认100ms
                .centerCrop()
                .into(iv);
    }


    /**
     * 加载本地图片 自定义动画 指定占位图
     * @param iv
     */
    public static void setNormalImage( int resId, ImageView iv,int placeholder) {
        Glide.with(MyApplication.getInstance().getMyApplication())
                .load(resId)
                .placeholder(placeholder)//加载之前的 默认占位图
                .error(placeholder)//图片无法加载时的 默认占位图
                .crossFade(duration)//淡入淡出动画 默认100ms
                .centerCrop()
                .into(iv);
    }


    /**
     * 加载本地图片 自定义动画
     *
     * @param context
     * @param animId
     * @param iv
     */
    public static void setNormalImage(Activity context, int resId, ImageView iv, int animId) {
        Glide.with(MyApplication.getInstance().getMyApplication())
                .load(resId)
                .placeholder(placeholder)//加载之前的 默认占位图
                .error(error)//图片无法加载时的 默认占位图
                .animate(animId)
                .centerCrop()
                .into(iv);
    }


    /**
     * @param url
     * @param w_h
     * @return 七牛专属链接规范
     */
    public static String setWidthAndHeight(String url, String w_h) {
        StringBuilder sb = new StringBuilder(url);
        if (w_h != null) {
            String width = w_h.split("x")[0];
            String height = w_h.split("x")[1];
            if ("*".equals(width)) {
                sb.append("?imageView2/2/h/").append(height);
            } else if ("*".equals(height)) {
                sb.append("?imageView2/2/w/").append(width);
            } else {
                sb.append("?imageView2/2/w/").append(width).append("/h/").append(height);
            }
        }
        if (sb.indexOf("imageView2/2") > 0) {
            sb.append("/format/webp");
        } else {
            sb.append("imageView2/2/format/webp");
        }
        return sb.toString();
    }


////////////////////////////////////////////////////#####################################################################
////////////////////////////////////////////////////#####################################################################
////////////////////////////////////////////////////#####################################################################
////////////////////////////////////////////////////#####################################################################
////////////////////////////////////////////////////#####################################################################
////////////////////////////////////////////////////#####################################################################


    /**
     * 加载网络图片 图片完全显示出来（可能被压缩）
     */
    public static void loadCenterCropImage(Activity context,String path, int picture, ImageView iv) {
        if(context!=null)
        Glide.with(context)
                .load(path)
                .placeholder(picture)//加载之前的 默认占位图
                .error(picture)//图片无法加载时的 默认占位图
                .into(iv);
    }
    /**
     * 加载网络图片 图片完全显示出来（可能被压缩）
     *
     * @param context
     * @param url
     * @param iv
     */
    public static void loadCenterCropImage(Activity context, String url, ImageView iv) {
        if(context!=null)
        Glide.with(context)
                .load(url)
//                .placeholder(placeholder)//加载之前的 默认占位图
//                .error(error)//图片无法加载时的 默认占位图
                .crossFade(duration)//淡入淡出动画 默认100ms
                .centerCrop()
                .into(iv);
    }

    /**
     * 加载网络图片 带Url前缀 图片完全显示出来（可能被压缩）
     *
     * @param context
     * @param url
     * @param iv
     */
    public static void loadCenterCropImage(Activity context, String url, ImageView iv,String prefix) {
        if(context!=null)
        Glide.with(context)
                .load(prefix + url)
//                .placeholder(placeholder)//加载之前的 默认占位图
//                .error(error)//图片无法加载时的 默认占位图
                .crossFade(duration)//淡入淡出动画 默认100ms
                .centerCrop()
                .into(iv);
    }

    /**
     * 加载网络图片 全屏显示（不一定图片完全显示全）
     *
     * @param context
     * @param url
     * @param iv
     */
    public static void loadDefaultImage(Activity context, String url, ImageView iv) {
        if(context!=null)
        Glide.with(context)
                .load(url)
//                .placeholder(placeholder)//加载之前的 默认占位图
//                .error(error)//图片无法加载时的 默认占位图
                .crossFade(duration)//淡入淡出动画 默认100ms
                .into(iv);
    }

    public static void load(Activity context, String url, ImageView iv) {
        if(context!=null)
        Glide.with(context)
                .load(url)
                //.placeholder(placeholder)//加载之前的 默认占位图
//                .error(error)//图片无法加载时的 默认占位图
                //.crossFade(duration)//淡入淡出动画 默认100ms
                .into(iv);
    }

    /**
     * 加载网络图片 带Url前缀 全屏显示（不一定图片完全显示全）
     *
     * @param context
     * @param url
     * @param iv
     */
    public static void loadDefaultImage(Activity context, String url, ImageView iv,String prefix) {
        if(context!=null)
        Glide.with(context)
                .load(prefix + url)
//                .placeholder(placeholder)//加载之前的 默认占位图
//                .error(error)//图片无法加载时的 默认占位图
                .crossFade(duration)//淡入淡出动画 默认100ms
                .into(iv);
    }

    /**
     * 加载网络图片 圆形 带Url前缀
     *
     * @param context
     * @param url
     * @param iv
     */
    public static void loadRoundImage(final Activity context, String url, final ImageView iv) {
        ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {
                // if it's a custom view class, cast it here
                // then find subviews and do the animations
                // here, we just use the entire view for the fade animation
                view.setAlpha(0f);

                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
                fadeAnim.setDuration(duration);
                fadeAnim.start();
            }
        };

        Glide.with(MyApplication.getInstance().getMyApplication()).load(url).asBitmap().centerCrop()
                .placeholder(header_placeholder)
                .error(header_placeholder)
                .animate(animationObject)
                .into(new BitmapImageViewTarget(iv) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        Bitmap dst;
                        //将长方形图片裁剪成正方形图片
                        if (resource.getWidth() >= resource.getHeight()) {
                            dst = Bitmap.createBitmap(resource, resource.getWidth() / 2 - resource.getHeight() / 2, 0, resource.getHeight(), resource.getHeight()
                            );
                        } else {
                            dst = Bitmap.createBitmap(resource, 0, resource.getHeight() / 2 - resource.getWidth() / 2, resource.getWidth(), resource.getWidth()
                            );
                        }
                        circularBitmapDrawable.setCornerRadius(dst.getWidth() / 2); //设置圆角半径为正方形边长的一半
                        circularBitmapDrawable.setAntiAlias(true);

                        iv.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    /**
     * 加载网络图片 圆形 带Url前缀
     *
     * @param context
     * @param url
     * @param iv
     */
    public static void loadRoundImage(final Activity context, String url, final ImageView iv,String prefix) {
        ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {
                // if it's a custom view class, cast it here
                // then find subviews and do the animations
                // here, we just use the entire view for the fade animation
                view.setAlpha(0f);

                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
                fadeAnim.setDuration(duration);
                fadeAnim.start();
            }
        };

        Glide.with(context).load(prefix+url).asBitmap().centerCrop()
                .placeholder(header_placeholder)
                .error(header_placeholder)
                .animate(animationObject)
                .into(new BitmapImageViewTarget(iv) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        Bitmap dst;
                        //将长方形图片裁剪成正方形图片
                        if (resource.getWidth() >= resource.getHeight()) {
                            dst = Bitmap.createBitmap(resource, resource.getWidth() / 2 - resource.getHeight() / 2, 0, resource.getHeight(), resource.getHeight()
                            );
                        } else {
                            dst = Bitmap.createBitmap(resource, 0, resource.getHeight() / 2 - resource.getWidth() / 2, resource.getWidth(), resource.getWidth()
                            );
                        }
                        //设置圆角半径为正方形边长的一半
                        circularBitmapDrawable.setCornerRadius(dst.getWidth() / 2);
                        circularBitmapDrawable.setAntiAlias(true);

                        iv.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    //根据网络url 获取bitmap
    public static void getBitmap(final Activity mContext , String url, final Callback callback){

        final Bitmap[] myBitmap = {null};
        Glide.with(mContext).load(url).asBitmap().centerCrop()
//                .placeholder(placeholder)//加载之前的 默认占位图
//                .error(error)//图片无法加载时的 默认占位图
                .into(new SimpleTarget<Bitmap>(200, 200) {
                    @Override
                    public void onResourceReady(Bitmap bitmap, GlideAnimation anim) {
                       callback.response(bitmap);
                    }
                });
    }

    public interface Callback{
        void  response(Bitmap b);
    }
}
