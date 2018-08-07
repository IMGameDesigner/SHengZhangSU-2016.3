package com.example.shengzhangsu;

import java.util.HashMap;

import com.example.shengzhangsu2.R;//w
import com.example.shengzhangsu.MainActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	MediaPlayer player[]=new MediaPlayer[6];
	ProgressBar jindutiao;
	android.view.ViewGroup.LayoutParams lp; //java设置imageView宽高第一步
	SoundPool soundpool;
	HashMap<Integer,Integer>soundmap=new HashMap<Integer,Integer>();
	int w,h;
	int w1,h1,w2,h2,w3,h3,w4,v1,x1,v2,x2;//只在timer里修改
	int caser,casert,guanshow,guanshowt,noteshow,noteshowt;
	ImageView 
	button1,dengji,money,chuangguan,knife,zhi,xi,yun,guang,jia1,jia2,jia3,jia4,jia5,hua[]=new ImageView[9],
	brownpaper,gamebackground,buttonbackground,i1,leftsun,rightsun
	,directionbutton1,directionbutton2,directionbutton3,notebackground,succeedorfail,arrow,test,guanpictrue,halfsee,txtpictrue
	,playpictrueup,playpictruedown,tiaoguo,tree,firstsay;
	TextView dengjitext,moneytext,knifetext,zhitext,xitext,yuntext,guangtext,talktext;
	Handler handler;
	int jindu=0;
	int wj_dengjiorguan,wj_money,wj_sell[]=new int[6],wj_buytrue[]=new int[6];
	int plantcaser,surroundings;
	int beautiful_buying,beautiful_buyingt;
	int whati1;//?
	int huax[]=new int[9],huay[]=new int[9];
	int aimright[]=new int[23],finalright;
	int teacheredcaser;
	int playi,playl[]=new int[1000],playt_s[]=new int[1000],nowplaywhich;
	boolean upneedmove;int upmovet,upmovev,upmovex;
	boolean win=false;
	int failtime[]=new int[23],failtimei;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jindutiao=(ProgressBar)findViewById(R.id.jindutiao);
        jindutiao.setProgress(jindu);
        soundpool=new SoundPool(26,AudioManager.STREAM_SYSTEM,0);
        soundmap.put(1, soundpool.load(this,R.raw.clickfinish,1));
        soundmap.put(2, soundpool.load(this,R.raw.clickjia,1));
        soundmap.put(3, soundpool.load(this,R.raw.clickknifeandon,1));
        soundmap.put(4, soundpool.load(this,R.raw.clickshengzhangsu,1));
        soundmap.put(5, soundpool.load(this,R.raw.succeed,1));
        soundmap.put(6, soundpool.load(this,R.raw.praise1,1));
        soundmap.put(7, soundpool.load(this,R.raw.praise9,1));
        soundmap.put(8, soundpool.load(this,R.raw.praise17,1));
        soundmap.put(9, soundpool.load(this,R.raw.praise2,1));
        soundmap.put(10, soundpool.load(this,R.raw.praise3,1));
        soundmap.put(11, soundpool.load(this,R.raw.praise16,1));
        soundmap.put(12, soundpool.load(this,R.raw.praise4,1));
        soundmap.put(13, soundpool.load(this,R.raw.praise5,1));
        soundmap.put(14, soundpool.load(this,R.raw.praise21,1));
        soundmap.put(15, soundpool.load(this,R.raw.praise6,1));
        soundmap.put(16, soundpool.load(this,R.raw.praise7,1));
        soundmap.put(17, soundpool.load(this,R.raw.praise8,1));
        soundmap.put(18, soundpool.load(this,R.raw.praise18,1));
        soundmap.put(19, soundpool.load(this,R.raw.praise10,1));
        soundmap.put(20, soundpool.load(this,R.raw.praise20,1));
        soundmap.put(21, soundpool.load(this,R.raw.praise11,1));
        soundmap.put(22, soundpool.load(this,R.raw.praise19,1));
        soundmap.put(23, soundpool.load(this,R.raw.praise12,1));
        soundmap.put(24, soundpool.load(this,R.raw.praise15,1));
        soundmap.put(25, soundpool.load(this,R.raw.praise13,1));
        soundmap.put(26, soundpool.load(this,R.raw.praise14,1));
        //soundpool.play(soundmap.get(1), 1, 1, 0, 0,1);
        
        jindu+=10;jindutiao.setProgress(jindu);
        
        button1=(ImageView)findViewById(R.id.button1);
        dengji=(ImageView)findViewById(R.id.dengji);
        money=(ImageView)findViewById(R.id.money);
        chuangguan=(ImageView)findViewById(R.id.chuangguan);
        jia1=(ImageView)findViewById(R.id.jia1);
        jia2=(ImageView)findViewById(R.id.jia2);
        knife=(ImageView)findViewById(R.id.knife);
        zhi=(ImageView)findViewById(R.id.zhi);
        xi=(ImageView)findViewById(R.id.xi);
        yun=(ImageView)findViewById(R.id.yun);
        guang=(ImageView)findViewById(R.id.guang);
        jia3=(ImageView)findViewById(R.id.jia3);
        jia4=(ImageView)findViewById(R.id.jia4);
        jia5=(ImageView)findViewById(R.id.jia5);
        
        dengjitext=(TextView)findViewById(R.id.dengjitext);
        moneytext=(TextView)findViewById(R.id.moneytext);
        knifetext=(TextView)findViewById(R.id.knifetext);
        zhitext=(TextView)findViewById(R.id.zhitext);
        xitext=(TextView)findViewById(R.id.xitext);
        yuntext=(TextView)findViewById(R.id.yuntext);
        guangtext=(TextView)findViewById(R.id.guangtext);
        talktext=(TextView)findViewById(R.id.talktext);

       Typeface typeFace =Typeface.createFromAsset(getAssets(),"fonts/simsun.ttf");
       dengjitext.setTypeface(typeFace);
       moneytext.setTypeface(typeFace);
       knifetext.setTypeface(typeFace);
       zhitext.setTypeface(typeFace);
       xitext.setTypeface(typeFace);
       yuntext.setTypeface(typeFace);
       guangtext.setTypeface(typeFace);
       talktext.setTypeface(typeFace);
        
       jindu+=10;jindutiao.setProgress(jindu);
       
        hua[1]=(ImageView)findViewById(R.id.hua1);
        hua[2]=(ImageView)findViewById(R.id.hua2);
        hua[3]=(ImageView)findViewById(R.id.hua3);
        hua[4]=(ImageView)findViewById(R.id.hua4);
        hua[5]=(ImageView)findViewById(R.id.hua5);
        hua[6]=(ImageView)findViewById(R.id.hua6);
        hua[7]=(ImageView)findViewById(R.id.hua7);
        hua[8]=(ImageView)findViewById(R.id.hua8);
        
        brownpaper=(ImageView)findViewById(R.id.brownpaper);
        gamebackground=(ImageView)findViewById(R.id.gamebackground);
        buttonbackground=(ImageView)findViewById(R.id.buttonbackground);
        i1=(ImageView)findViewById(R.id.i1);
        leftsun=(ImageView)findViewById(R.id.leftsun);
        rightsun=(ImageView)findViewById(R.id.rightsun);
        directionbutton1=(ImageView)findViewById(R.id.directionbutton1);
        directionbutton2=(ImageView)findViewById(R.id.directionbutton2);
        directionbutton3=(ImageView)findViewById(R.id.directionbutton3);
        notebackground=(ImageView)findViewById(R.id.notebackground);
        succeedorfail=(ImageView)findViewById(R.id.succeedorfail);
        arrow=(ImageView)findViewById(R.id.arrow);
        test=(ImageView)findViewById(R.id.test);
        guanpictrue=(ImageView)findViewById(R.id.guanpictrue);
        halfsee=(ImageView)findViewById(R.id.halfsee);
        txtpictrue=(ImageView)findViewById(R.id.txtpictrue);
        playpictrueup=(ImageView)findViewById(R.id.playpictrueup);
        playpictruedown=(ImageView)findViewById(R.id.playpictruedown);
        tiaoguo=(ImageView)findViewById(R.id.tiaoguo);
        tree=(ImageView)findViewById(R.id.tree);
        firstsay=(ImageView)findViewById(R.id.firstsay);
        
        jindu+=10;jindutiao.setProgress(jindu);
        
        player[0]=MediaPlayer.create(this,R.raw.teachermusic0);
        player[1]=MediaPlayer.create(this,R.raw.teachermusic1);
        player[2]=MediaPlayer.create(this,R.raw.teachermusic2);
        player[3]=MediaPlayer.create(this,R.raw.teachermusic3);
        player[4]=MediaPlayer.create(this,R.raw.teachermusic4);
        player[5]=MediaPlayer.create(this,R.raw.teachermusic5);
        
        button1.setScaleType(ImageView.ScaleType.FIT_XY);
        dengji.setScaleType(ImageView.ScaleType.FIT_XY);
        money.setScaleType(ImageView.ScaleType.FIT_XY);
        chuangguan.setScaleType(ImageView.ScaleType.FIT_XY);
        jia1.setScaleType(ImageView.ScaleType.FIT_XY);
        jia2.setScaleType(ImageView.ScaleType.FIT_XY);
        knife.setScaleType(ImageView.ScaleType.FIT_XY);
        zhi.setScaleType(ImageView.ScaleType.FIT_XY);
        xi.setScaleType(ImageView.ScaleType.FIT_XY);
        yun.setScaleType(ImageView.ScaleType.FIT_XY);
        guang.setScaleType(ImageView.ScaleType.FIT_XY);
        jia3.setScaleType(ImageView.ScaleType.FIT_XY);
        jia4.setScaleType(ImageView.ScaleType.FIT_XY);
        jia5.setScaleType(ImageView.ScaleType.FIT_XY);
        hua[1].setScaleType(ImageView.ScaleType.FIT_XY);
        hua[2].setScaleType(ImageView.ScaleType.FIT_XY);
        hua[3].setScaleType(ImageView.ScaleType.FIT_XY);
        hua[4].setScaleType(ImageView.ScaleType.FIT_XY);
        hua[5].setScaleType(ImageView.ScaleType.FIT_XY);
        hua[6].setScaleType(ImageView.ScaleType.FIT_XY);
        hua[7].setScaleType(ImageView.ScaleType.FIT_XY);
        hua[8].setScaleType(ImageView.ScaleType.FIT_XY);
        brownpaper.setScaleType(ImageView.ScaleType.FIT_XY);
        gamebackground.setScaleType(ImageView.ScaleType.FIT_XY);
        buttonbackground.setScaleType(ImageView.ScaleType.FIT_XY);
        i1.setScaleType(ImageView.ScaleType.FIT_XY);
        leftsun.setScaleType(ImageView.ScaleType.FIT_XY);
        rightsun.setScaleType(ImageView.ScaleType.FIT_XY);
        directionbutton1.setScaleType(ImageView.ScaleType.FIT_XY);
        directionbutton2.setScaleType(ImageView.ScaleType.FIT_XY);
        directionbutton3.setScaleType(ImageView.ScaleType.FIT_XY);
        notebackground.setScaleType(ImageView.ScaleType.FIT_XY);
        succeedorfail.setScaleType(ImageView.ScaleType.FIT_XY);
        arrow.setScaleType(ImageView.ScaleType.FIT_XY);
        test.setScaleType(ImageView.ScaleType.FIT_XY);
        guanpictrue.setScaleType(ImageView.ScaleType.FIT_XY);
        halfsee.setScaleType(ImageView.ScaleType.FIT_XY);
        playpictrueup.setScaleType(ImageView.ScaleType.FIT_XY);
        playpictruedown.setScaleType(ImageView.ScaleType.FIT_XY);
        tiaoguo.setScaleType(ImageView.ScaleType.FIT_XY);
        tree.setScaleType(ImageView.ScaleType.FIT_XY);
        firstsay.setScaleType(ImageView.ScaleType.FIT_XY);
        //txtpictrue.setScaleType(ImageView.ScaleType.FIT_XY);

        jindu+=10;jindutiao.setProgress(jindu);
        
        //====================================获取屏幕分辨率
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);        
         w = dm.widthPixels;//宽度
         h = dm.heightPixels ;//高度
        //===============================]
       
     
    	//============load
    	button1.setVisibility(View.INVISIBLE);
    	 dengji.setVisibility(View.INVISIBLE);
         money.setVisibility(View.INVISIBLE);
         chuangguan.setVisibility(View.INVISIBLE);
         jia1.setVisibility(View.INVISIBLE);
         jia2.setVisibility(View.INVISIBLE);
         knife.setVisibility(View.INVISIBLE);
         zhi.setVisibility(View.INVISIBLE);
         xi.setVisibility(View.INVISIBLE);
         yun.setVisibility(View.INVISIBLE);
         guang.setVisibility(View.INVISIBLE);
         jia3.setVisibility(View.INVISIBLE);
         jia4.setVisibility(View.INVISIBLE);
         jia5.setVisibility(View.INVISIBLE);
         dengjitext.setVisibility(View.INVISIBLE);
         moneytext.setVisibility(View.INVISIBLE);
         knifetext.setVisibility(View.INVISIBLE);
         zhitext.setVisibility(View.INVISIBLE);
         xitext.setVisibility(View.INVISIBLE);
         yuntext.setVisibility(View.INVISIBLE);
         guangtext.setVisibility(View.INVISIBLE);
         hua[1].setVisibility(View.INVISIBLE);
         hua[2].setVisibility(View.INVISIBLE);
         hua[3].setVisibility(View.INVISIBLE);
         hua[4].setVisibility(View.INVISIBLE);
         hua[5].setVisibility(View.INVISIBLE);
         hua[6].setVisibility(View.INVISIBLE);
         hua[7].setVisibility(View.INVISIBLE);
         hua[8].setVisibility(View.INVISIBLE);
         talktext.setVisibility(View.INVISIBLE);
         brownpaper.setVisibility(View.INVISIBLE);
         gamebackground.setVisibility(View.INVISIBLE);
         buttonbackground.setVisibility(View.INVISIBLE);
         i1.setVisibility(View.INVISIBLE);
         leftsun.setVisibility(View.INVISIBLE);
         rightsun.setVisibility(View.INVISIBLE);
         directionbutton1.setVisibility(View.INVISIBLE);
         directionbutton2.setVisibility(View.INVISIBLE);
         directionbutton3.setVisibility(View.INVISIBLE);
         notebackground.setVisibility(View.INVISIBLE);
         succeedorfail.setVisibility(View.INVISIBLE);
         arrow.setVisibility(View.INVISIBLE);
         guanpictrue.setVisibility(View.INVISIBLE);
         halfsee.setVisibility(View.INVISIBLE);
         txtpictrue.setVisibility(View.INVISIBLE);
         playpictrueup.setVisibility(View.INVISIBLE);
         playpictruedown.setVisibility(View.INVISIBLE);
         tiaoguo.setVisibility(View.INVISIBLE);
         tree.setVisibility(View.INVISIBLE);
         firstsay.setVisibility(View.INVISIBLE);
         succeedorfail.setVisibility(View.INVISIBLE);
         
         jindu+=10;jindutiao.setProgress(jindu);
         jindutiao.setVisibility(View.INVISIBLE);

       //==================在java里设置imag                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   eView的宽高        	
			lp=test.getLayoutParams();
			lp.width=w/20;
			lp.height=h/20; 
			test.setLayoutParams(lp);
			//===========================================】
			test.setVisibility(View.INVISIBLE);
         
    	opencaser_1();
    	//=======================】
    	test.setOnClickListener(new OnClickListener(){
 		   public void onClick(View v){
			  // wj_money=10000;
		      // wj_dengjiorguan=21;
		      // closecaser_2();
		      // opencaser30();
		   }
	   });
    	
		
    	  button1.setOnClickListener(new OnClickListener(){
    		   public void onClick(View v){
    			   txtpictrue.setVisibility(View.INVISIBLE);
    			   soundpool.play(soundmap.get(4), 1, 1, 0, 0,1);
    			   closecaser_1();
    			   opencaser_3();
    		   }
    	   });
    	  chuangguan.setOnClickListener(new OnClickListener(){
    		  public void onClick(View v){
    			  
    			  if(caser==-2&&(teacheredcaser==7||teacheredcaser==3)&&wj_dengjiorguan<22)
    			       {if(teacheredcaser==3)teacheredcaser++;
    			       if(teacheredcaser==4){
    			       	arrow.setVisibility(View.VISIBLE);
    			        arrow.setX(w/6);
    			   	    arrow.setY(h-h/4+h/20);
    			   	    //==================在java里设置imageView的宽高        	
    			   	    lp=arrow.getLayoutParams();
    			   	    lp.width=h/8;
    			   	    lp.height=h/8; 
    			       	arrow.setLayoutParams(lp);
    			   	//===========================================】
    			       	
    			       	halfsee.setVisibility(View.VISIBLE);
    			    	halfsee.setImageResource(R.drawable.half4_5);
    			     	halfsee.setX(0);
    				    halfsee.setY(0);
    				    //==================在java里设置imageView的宽高        	
    				    lp=halfsee.getLayoutParams();
    				    lp.width=w;
    				    lp.height=h; 
    			    	halfsee.setLayoutParams(lp);
    				//===========================================】
    			       }
    			       closecaser_2();opencaser10();}else
    			  if(caser==10&&casert>21&&(teacheredcaser==7||teacheredcaser==6))
    			       {
    				  if(teacheredcaser==6)teacheredcaser++;
    			       arrow.setVisibility(View.INVISIBLE);
    			       halfsee.setVisibility(View.INVISIBLE);
    			       closecaser10();opencaser28();
    			       }else
    			  if(caser==-2&&wj_dengjiorguan==22)
    			       {closecaser_2();opencaser30();}
    		  }
    	  });
    	  knife.setOnClickListener(new OnClickListener(){
    		  public void onClick(View v){
    			  if(caser==10&&casert>21&&(teacheredcaser==7||teacheredcaser==4)&&(wj_dengjiorguan<=3)){
    				  soundpool.play(soundmap.get(3), 1, 1, 0, 0,1);
    				  if(teacheredcaser==4)teacheredcaser++;
    				  if(teacheredcaser==5){
      			       	arrow.setVisibility(View.VISIBLE);
      			        arrow.setX(0+h/20);
      			   	    arrow.setY(h/2-h/20+h/20);
      			   	    //==================在java里设置imageView的宽高        	
      			   	    lp=arrow.getLayoutParams();
      			   	    lp.width=h/8;
      			   	    lp.height=h/8; 
      			       	arrow.setLayoutParams(lp);
      			   	//===========================================】
      			       	
      			    halfsee.setVisibility(View.VISIBLE);
      		    	halfsee.setImageResource(R.drawable.half5_6);
      		     	halfsee.setX(0);
      			    halfsee.setY(0);
      			    //==================在java里设置imageView的宽高        	
      			    lp=halfsee.getLayoutParams();
      			    lp.width=w;
      			    lp.height=h; 
      		    	halfsee.setLayoutParams(lp);
      			//===========================================】
      			       }
    				 closecaser10();opencaser21();
    			  }
    		  }
    	  });
    	  zhi.setOnClickListener(new OnClickListener(){
    		  public void onClick(View v){
    			  
    			  boolean plantcasers[]=new boolean[9];
					int plc=plantcaser;
					if (plc>=256){plc-=256;plantcasers[8]=true;}else plantcasers[8]=false;
					if (plc>=128){plc-=128;plantcasers[7]=true;}else plantcasers[7]=false;
					if (plc>=64){plc-=64;plantcasers[6]=true;}else plantcasers[6]=false;
					if (plc>=32){plc-=32;plantcasers[5]=true;}else plantcasers[5]=false;
					if (plc>=16){plc-=16;plantcasers[4]=true;}else plantcasers[4]=false;
					if (plc>=8){plc-=8;plantcasers[3]=true;}else plantcasers[3]=false;
					if (plc>=4){plc-=4;plantcasers[2]=true;}else plantcasers[2]=false;
					if (plc>=2){plc-=2;plantcasers[1]=true;}else plantcasers[1]=false;
    			  
    			  if(caser==10&&casert>21&&plantcasers[1]&&teacheredcaser==7){
    				  soundpool.play(soundmap.get(3), 1, 1, 0, 0,1);
    				 closecaser10();opencaser22();
    			  }
    		  }
    	  });
    	  xi.setOnClickListener(new OnClickListener(){
    		  public void onClick(View v){
    			  
    			  boolean plantcasers[]=new boolean[9];
					int plc=plantcaser;
					if (plc>=256){plc-=256;plantcasers[8]=true;}else plantcasers[8]=false;
					if (plc>=128){plc-=128;plantcasers[7]=true;}else plantcasers[7]=false;
					if (plc>=64){plc-=64;plantcasers[6]=true;}else plantcasers[6]=false;
					if (plc>=32){plc-=32;plantcasers[5]=true;}else plantcasers[5]=false;
					if (plc>=16){plc-=16;plantcasers[4]=true;}else plantcasers[4]=false;
					if (plc>=8){plc-=8;plantcasers[3]=true;}else plantcasers[3]=false;
					if (plc>=4){plc-=4;plantcasers[2]=true;}else plantcasers[2]=false;
					if (plc>=2){plc-=2;plantcasers[1]=true;}else plantcasers[1]=false;
    			  
    			  if(caser==10&&casert>21&&plantcasers[1]==false){
    				  soundpool.play(soundmap.get(3), 1, 1, 0, 0,1);
    				 closecaser10();opencaser23();
    			  }
    		  }
    	  });
    	  yun.setOnClickListener(new OnClickListener(){
    		  public void onClick(View v){
    			  
    			  boolean plantcasers[]=new boolean[9];
					int plc=plantcaser;
					if (plc>=256){plc-=256;plantcasers[8]=true;}else plantcasers[8]=false;
					if (plc>=128){plc-=128;plantcasers[7]=true;}else plantcasers[7]=false;
					if (plc>=64){plc-=64;plantcasers[6]=true;}else plantcasers[6]=false;
					if (plc>=32){plc-=32;plantcasers[5]=true;}else plantcasers[5]=false;
					if (plc>=16){plc-=16;plantcasers[4]=true;}else plantcasers[4]=false;
					if (plc>=8){plc-=8;plantcasers[3]=true;}else plantcasers[3]=false;
					if (plc>=4){plc-=4;plantcasers[2]=true;}else plantcasers[2]=false;
					if (plc>=2){plc-=2;plantcasers[1]=true;}else plantcasers[1]=false;
    			  
    			  if(caser==10&&casert>21&&plantcasers[1]==false){
    				 soundpool.play(soundmap.get(3), 1, 1, 0, 0,1);
    				 closecaser10();opencaser24();
    			  }
    		  }
    	  });
    	  guang.setOnClickListener(new OnClickListener(){
    		  public void onClick(View v){
    			  if(caser==10&&casert>21){
    				 soundpool.play(soundmap.get(3), 1, 1, 0, 0,1);
    				 closecaser10();opencaser25();
    			  }
    		  }
    	  });
    	  directionbutton1.setOnClickListener(new OnClickListener(){
    		  public void onClick(View v){
    			  if(caser==21){
    				  
    					boolean plantcasers[]=new boolean[9];
    					int plc=plantcaser;
    					if (plc>=256){plc-=256;plantcasers[8]=true;}else plantcasers[8]=false;
    					if (plc>=128){plc-=128;plantcasers[7]=true;}else plantcasers[7]=false;
    					if (plc>=64){plc-=64;plantcasers[6]=true;}else plantcasers[6]=false;
    					if (plc>=32){plc-=32;plantcasers[5]=true;}else plantcasers[5]=false;
    					if (plc>=16){plc-=16;plantcasers[4]=true;}else plantcasers[4]=false;
    					if (plc>=8){plc-=8;plantcasers[3]=true;}else plantcasers[3]=false;
    					if (plc>=4){plc-=4;plantcasers[2]=true;}else plantcasers[2]=false;
    					if (plc>=2){plc-=2;plantcasers[1]=true;}else plantcasers[1]=false;
    					
    					if(plantcasers[1]==false){plantcaser+=2;}
    				  if(teacheredcaser==5)teacheredcaser++;
    				  if(teacheredcaser==6){
        			       	arrow.setVisibility(View.VISIBLE);
        			        arrow.setX(w*3/4-h/20);
        			   	    arrow.setY(h-h/10);
        			   	    //==================在java里设置imageView的宽高        	
        			   	    lp=arrow.getLayoutParams();
        			   	    lp.width=h/8;
        			   	    lp.height=h/8; 
        			       	arrow.setLayoutParams(lp);
        			   	//===========================================】
        			       	
        			       	halfsee.setVisibility(View.VISIBLE);
        			    	halfsee.setImageResource(R.drawable.half6_7);
        			     	halfsee.setX(0);
        				    halfsee.setY(0);
        				    //==================在java里设置imageView的宽高        	
        				    lp=halfsee.getLayoutParams();
        				    lp.width=w;
        				    lp.height=h; 
        			    	halfsee.setLayoutParams(lp);
        				//===========================================】
        			       }
    				  closecaser21();opencaser10();
    			  }
    			  if(caser==22){
    				  
  					boolean plantcasers[]=new boolean[9];
  					int plc=plantcaser;
  					if (plc>=256){plc-=256;plantcasers[8]=true;}else plantcasers[8]=false;
  					if (plc>=128){plc-=128;plantcasers[7]=true;}else plantcasers[7]=false;
  					if (plc>=64){plc-=64;plantcasers[6]=true;}else plantcasers[6]=false;
  					if (plc>=32){plc-=32;plantcasers[5]=true;}else plantcasers[5]=false;
  					if (plc>=16){plc-=16;plantcasers[4]=true;}else plantcasers[4]=false;
  					if (plc>=8){plc-=8;plantcasers[3]=true;}else plantcasers[3]=false;
  					if (plc>=4){plc-=4;plantcasers[2]=true;}else plantcasers[2]=false;
  					if (plc>=2){plc-=2;plantcasers[1]=true;}else plantcasers[1]=false;
  					
  					if(plantcasers[2]==false){plantcaser+=4;}
  				  
  				  closecaser22();opencaser10();
  			      }
    			  if(caser==23){
    				  
    					boolean plantcasers[]=new boolean[9];
    					int plc=plantcaser;
    					if (plc>=256){plc-=256;plantcasers[8]=true;}else plantcasers[8]=false;
    					if (plc>=128){plc-=128;plantcasers[7]=true;}else plantcasers[7]=false;
    					if (plc>=64){plc-=64;plantcasers[6]=true;}else plantcasers[6]=false;
    					if (plc>=32){plc-=32;plantcasers[5]=true;}else plantcasers[5]=false;
    					if (plc>=16){plc-=16;plantcasers[4]=true;}else plantcasers[4]=false;
    					if (plc>=8){plc-=8;plantcasers[3]=true;}else plantcasers[3]=false;
    					if (plc>=4){plc-=4;plantcasers[2]=true;}else plantcasers[2]=false;
    					if (plc>=2){plc-=2;plantcasers[1]=true;}else plantcasers[1]=false;
    					
    					if(plantcasers[4]==false){plantcaser+=16;}
    				  
    				  closecaser23();opencaser10();
    			      }
    			  if(caser==24){
    				  
    					boolean plantcasers[]=new boolean[9];
    					int plc=plantcaser;
    					if (plc>=256){plc-=256;plantcasers[8]=true;}else plantcasers[8]=false;
    					if (plc>=128){plc-=128;plantcasers[7]=true;}else plantcasers[7]=false;
    					if (plc>=64){plc-=64;plantcasers[6]=true;}else plantcasers[6]=false;
    					if (plc>=32){plc-=32;plantcasers[5]=true;}else plantcasers[5]=false;
    					if (plc>=16){plc-=16;plantcasers[4]=true;}else plantcasers[4]=false;
    					if (plc>=8){plc-=8;plantcasers[3]=true;}else plantcasers[3]=false;
    					if (plc>=4){plc-=4;plantcasers[2]=true;}else plantcasers[2]=false;
    					if (plc>=2){plc-=2;plantcasers[1]=true;}else plantcasers[1]=false;
    					
    					if(plantcasers[7]==false){plantcaser+=128;}
    				  
    				  closecaser24();opencaser10();
    			      }
    		
    			  if(caser==25){
    				  
    				  boolean upsunhave,downsunhave,leftsunhave,rightsunhave;
        			  int sunhave;
        			  sunhave=surroundings;
        			  if(sunhave>=8){sunhave-=8;rightsunhave=true;}else rightsunhave=false;
        			  if(sunhave>=4){sunhave-=4;leftsunhave=true;}else leftsunhave=false;
        			  if(sunhave>=2){sunhave-=2;downsunhave=true;}else downsunhave=false;
        			  if(sunhave>=1){sunhave-=1;upsunhave=true;}else upsunhave=false;
  					
  					if(leftsunhave==false){surroundings+=4;}
  				  
  				  closecaser25();opencaser10();
  			      }
    		  }
    	  });
    	  directionbutton2.setOnClickListener(new OnClickListener(){
    		  public void onClick(View v){
    			  if(caser==22){
    				  
    					boolean plantcasers[]=new boolean[9];
    					int plc=plantcaser;
    					if (plc>=256){plc-=256;plantcasers[8]=true;}else plantcasers[8]=false;
    					if (plc>=128){plc-=128;plantcasers[7]=true;}else plantcasers[7]=false;
    					if (plc>=64){plc-=64;plantcasers[6]=true;}else plantcasers[6]=false;
    					if (plc>=32){plc-=32;plantcasers[5]=true;}else plantcasers[5]=false;
    					if (plc>=16){plc-=16;plantcasers[4]=true;}else plantcasers[4]=false;
    					if (plc>=8){plc-=8;plantcasers[3]=true;}else plantcasers[3]=false;
    					if (plc>=4){plc-=4;plantcasers[2]=true;}else plantcasers[2]=false;
    					if (plc>=2){plc-=2;plantcasers[1]=true;}else plantcasers[1]=false;
    					
    					if(plantcasers[3]==false){plantcaser+=8;}
    				  
    				  closecaser22();opencaser10();
    			  }
    			  if(caser==23){
    				  
    					boolean plantcasers[]=new boolean[9];
    					int plc=plantcaser;
    					if (plc>=256){plc-=256;plantcasers[8]=true;}else plantcasers[8]=false;
    					if (plc>=128){plc-=128;plantcasers[7]=true;}else plantcasers[7]=false;
    					if (plc>=64){plc-=64;plantcasers[6]=true;}else plantcasers[6]=false;
    					if (plc>=32){plc-=32;plantcasers[5]=true;}else plantcasers[5]=false;
    					if (plc>=16){plc-=16;plantcasers[4]=true;}else plantcasers[4]=false;
    					if (plc>=8){plc-=8;plantcasers[3]=true;}else plantcasers[3]=false;
    					if (plc>=4){plc-=4;plantcasers[2]=true;}else plantcasers[2]=false;
    					if (plc>=2){plc-=2;plantcasers[1]=true;}else plantcasers[1]=false;
    					
    					if(plantcasers[5]==false){plantcaser+=32;}
    				  
    				  closecaser23();opencaser10();
    			      }
    			  if(caser==24){
    				  
    					boolean plantcasers[]=new boolean[9];
    					int plc=plantcaser;
    					if (plc>=256){plc-=256;plantcasers[8]=true;}else plantcasers[8]=false;
    					if (plc>=128){plc-=128;plantcasers[7]=true;}else plantcasers[7]=false;
    					if (plc>=64){plc-=64;plantcasers[6]=true;}else plantcasers[6]=false;
    					if (plc>=32){plc-=32;plantcasers[5]=true;}else plantcasers[5]=false;
    					if (plc>=16){plc-=16;plantcasers[4]=true;}else plantcasers[4]=false;
    					if (plc>=8){plc-=8;plantcasers[3]=true;}else plantcasers[3]=false;
    					if (plc>=4){plc-=4;plantcasers[2]=true;}else plantcasers[2]=false;
    					if (plc>=2){plc-=2;plantcasers[1]=true;}else plantcasers[1]=false;
    					
    					if(plantcasers[8]==false){plantcaser+=256;}
    				  
    				  closecaser24();opencaser10();
    			      }
                    if(caser==25){
    				  
    				  boolean upsunhave,downsunhave,leftsunhave,rightsunhave;
        			  int sunhave;
        			  sunhave=surroundings;
        			  if(sunhave>=8){sunhave-=8;rightsunhave=true;}else rightsunhave=false;
        			  if(sunhave>=4){sunhave-=4;leftsunhave=true;}else leftsunhave=false;
        			  if(sunhave>=2){sunhave-=2;downsunhave=true;}else downsunhave=false;
        			  if(sunhave>=1){sunhave-=1;upsunhave=true;}else upsunhave=false;
  					
  					if(rightsunhave==false){surroundings+=8;}
  				  
  				  closecaser25();opencaser10();
  			      }
    		  }
    	  });
    	  directionbutton3.setOnClickListener(new OnClickListener(){
    		  public void onClick(View v){
    			  if(caser==24){
    				  
    					boolean plantcasers[]=new boolean[9];
    					int plc=plantcaser;
    					if (plc>=256){plc-=256;plantcasers[8]=true;}else plantcasers[8]=false;
    					if (plc>=128){plc-=128;plantcasers[7]=true;}else plantcasers[7]=false;
    					if (plc>=64){plc-=64;plantcasers[6]=true;}else plantcasers[6]=false;
    					if (plc>=32){plc-=32;plantcasers[5]=true;}else plantcasers[5]=false;
    					if (plc>=16){plc-=16;plantcasers[4]=true;}else plantcasers[4]=false;
    					if (plc>=8){plc-=8;plantcasers[3]=true;}else plantcasers[3]=false;
    					if (plc>=4){plc-=4;plantcasers[2]=true;}else plantcasers[2]=false;
    					if (plc>=2){plc-=2;plantcasers[1]=true;}else plantcasers[1]=false;
    					
    					if(plantcasers[6]==false){plantcaser+=64;}
    				  
    				  closecaser24();opencaser10();
    			      }
    		  }
    	  });
    	  notebackground.setOnClickListener(new OnClickListener(){
    		  public void onClick(View v){
    			  if(caser==-2){
    				    noteshow=0; noteshowt=0; 
    				    talktext.setVisibility(View.INVISIBLE);
    			  }
    		  }
    	  });
    	  jia1.setOnClickListener(new OnClickListener(){
    		  public void onClick(View v){
    			  soundpool.play(soundmap.get(2), 1, 1, 0, 0,1);
    			  if(caser==-2&&(teacheredcaser==7||teacheredcaser==2||teacheredcaser==0)){
    				  if(wj_buytrue[1]==0){
    					  if(teacheredcaser==0)teacheredcaser++;
    					  arrow.setVisibility(View.INVISIBLE);
    					  beautiful_buying=1;
    					  wj_buytrue[1]=1;
    					  wj_money-=wj_sell[1];
    					  opencaser_2();
    				  }else
    				  {
    					if(teacheredcaser==2)teacheredcaser++;
    					if(teacheredcaser==3){
    				    	arrow.setVisibility(View.VISIBLE);
    				     	arrow.setX(w*3/4-w/20);
    					    arrow.setY(h-h/8);
    					    //==================在java里设置imageView的宽高        	
    					    lp=arrow.getLayoutParams();
    					    lp.width=h/8;
    					    lp.height=h/8; 
    				    	arrow.setLayoutParams(lp);
    					//===========================================】
    				    	
    				    	halfsee.setVisibility(View.VISIBLE);
    				    	halfsee.setImageResource(R.drawable.half3_4);
    				     	halfsee.setX(0);
    					    halfsee.setY(0);
    					    //==================在java里设置imageView的宽高        	
    					    lp=halfsee.getLayoutParams();
    					    lp.width=w;
    					    lp.height=h; 
    				    	halfsee.setLayoutParams(lp);
    					//===========================================】
    				    }
    					noteshow=1; noteshowt=0; 
    					  
    					notebackground.setVisibility(View.VISIBLE);
                        //==================在java里设置imageView的宽高        	
    					lp=notebackground.getLayoutParams();
    					lp.width=1;
    					lp.height=1; 
    					notebackground.setLayoutParams(lp);
    					//===========================================】
    					notebackground.setX(w/2);
    					notebackground.setY(h/2);
    					
    				    talktext.setVisibility(View.INVISIBLE);
    					//==================在java里设置imageView的宽高        	
    					lp=talktext.getLayoutParams();
    					lp.width=w/2;
    					lp.height=h/2/2; 
    					talktext.setLayoutParams(lp);
    					//===========================================】
    					talktext.setX(w/2-w/4);
    					talktext.setY(h/2-h/20);
    					talktext.setTextSize(20);
    					talktext.setTextColor(Color.parseColor("#000000"));
    					talktext.setText("去尖小刀：可以去掉胚芽鞘的尖端");
    				  }
    			  }
    		  }
    	  });
    	  jia2.setOnClickListener(new OnClickListener(){
    		  public void onClick(View v){
    			  soundpool.play(soundmap.get(2), 1, 1, 0, 0,1);
    			  if(caser==-2&&(teacheredcaser==7||teacheredcaser==1)){
    				  if(wj_buytrue[2]==0){
    					  if(teacheredcaser==1)teacheredcaser++;
    					  beautiful_buying=2;
    					  wj_buytrue[2]=1;
    					  wj_money-=wj_sell[2];
    					  opencaser_2();
    				  }else
    				  {
    					noteshow=1; noteshowt=0;   
    					  
    					notebackground.setVisibility(View.VISIBLE); 

    					talktext.setVisibility(View.INVISIBLE);
    					//==================在java里设置imageView的宽高        	
    					lp=talktext.getLayoutParams();
    					lp.width=w/2;
    					lp.height=h/2/2; 
    					talktext.setLayoutParams(lp);
    					//===========================================】
    					talktext.setX(w/2-w/4);
    					talktext.setY(h/2-h/20);
    					talktext.setTextSize(20);
    					talktext.setTextColor(Color.parseColor("#000000"));
    					talktext.setText("琼脂块：内含生长素，可以放在去尖胚芽鞘上");
    				  }
    			  }
    		  }
    	  });
    	  jia3.setOnClickListener(new OnClickListener(){
    		  public void onClick(View v){
    			  soundpool.play(soundmap.get(2), 1, 1, 0, 0,1);
    			  if(caser==-2){
    				  if(wj_buytrue[3]==0){
    					  beautiful_buying=3;
    					  wj_buytrue[3]=1;
    					  wj_money-=wj_sell[3];
    					  opencaser_2();
    				  }else
    				  {
    					  noteshow=1; noteshowt=0;   
    					  
    					notebackground.setVisibility(View.VISIBLE); 

    					talktext.setVisibility(View.INVISIBLE);
    					//==================在java里设置imageView的宽高        	
    					lp=talktext.getLayoutParams();
    					lp.width=w/2;
    					lp.height=h/2/2; 
    					talktext.setLayoutParams(lp);
    					//===========================================】
    					talktext.setX(w/2-w/4);
    					talktext.setY(h/2-h/20);
    					talktext.setTextSize(20);
    					talktext.setTextColor(Color.parseColor("#000000"));
    					talktext.setText("锡纸：不透光，可以贴在胚芽鞘尖端一侧");
    				  }
    			  }
    		  }
    	  });
    	  jia4.setOnClickListener(new OnClickListener(){
    		  public void onClick(View v){
    			  soundpool.play(soundmap.get(2), 1, 1, 0, 0,1);
    			  if(caser==-2){
    				  if(wj_buytrue[4]==0){
    					  beautiful_buying=4;
    					  wj_buytrue[4]=1;
    					  wj_money-=wj_sell[4];
    					  opencaser_2();
    				  }else
    				  {
    					  noteshow=1; noteshowt=0; 
    					  
    					notebackground.setVisibility(View.VISIBLE);  
    					
    					talktext.setVisibility(View.INVISIBLE);
    					//==================在java里设置imageView的宽高        	
    					lp=talktext.getLayoutParams();
    					lp.width=w/2;
    					lp.height=h/2/2; 
    					talktext.setLayoutParams(lp);
    					//===========================================】
    					talktext.setX(w/2-w/4);
    					talktext.setY(h/2-h/20);
    					talktext.setTextSize(20);
    					talktext.setTextColor(Color.parseColor("#000000"));
    					talktext.setText("云母片/玻璃片：可以插入胚芽鞘，水和生长素都不能通过它");
    				  }
    			  }
    		  }
    	  });
    	  jia5.setOnClickListener(new OnClickListener(){
    		  public void onClick(View v){
    			  soundpool.play(soundmap.get(2), 1, 1, 0, 0,1);
    			  if(caser==-2){
    				  if(wj_buytrue[5]==0){
    					  beautiful_buying=5;
    					  wj_buytrue[5]=1;
    					  wj_money-=wj_sell[5];
    					  opencaser_2();
    				  }else
    				  {
    					  noteshow=1; noteshowt=0;  
    					  
    					notebackground.setVisibility(View.VISIBLE);  
    					
    					talktext.setVisibility(View.INVISIBLE);
    					//==================在java里设置imageView的宽高        	
    					lp=talktext.getLayoutParams();
    					lp.width=w/2;
    					lp.height=h/2/2; 
    					talktext.setLayoutParams(lp);
    					//===========================================】
    					talktext.setX(w/2-w/4);
    					talktext.setY(h/2-h/20);
    					talktext.setTextSize(20);
    					talktext.setTextColor(Color.parseColor("#000000"));
    					talktext.setText("人造太阳光：可以当作自然光线");
    				  }
    			  }
    		  }
    	  });
    	  tiaoguo.setOnClickListener(new OnClickListener(){
    		  public void onClick(View v){
    			  player[0].start();player[0].pause();player[0].seekTo(0);
    			  player[1].start();player[1].pause();player[1].seekTo(0);
    			  player[2].start();player[2].pause();player[2].seekTo(0);
    			  player[3].start();player[3].pause();player[3].seekTo(0);
    			  player[4].start();player[4].pause();player[4].seekTo(0);
    			  player[5].start();player[5].pause();player[5].seekTo(0);
    			  closecaser_3();
    			  opencaser_2();
    			  
    		  }
    	  });
       handler=new Handler(){
    		@Override
        	public void handleMessage(Message msg){
        		if(msg.what==0x101){
        			//talktext.setVisibility(View.VISIBLE);
        			//talktext.setText(" "+plantcaser);
        			//caser_1
        			if(caser==-3){
        				if(casert==0){
        				if(playi>0){
        					player[playl[1]].start();
        					//player[playl[1]].pause();player[playl[1]].seekTo(0);player[playl[1]].start();
        					nowplaywhich=playl[1];
        					setplaypictrueupbegin(playl[1]);//输入音乐号，up图变对应音乐刚开始的图
        					playi--;
        					int playfi;
        					for(playfi=1;playfi<=playi;playfi++)playl[playfi]=playl[playfi+1];
        				}else if(playi==0)
        					{
        					     closecaser_3();
        					     opencaser_2();
        					}
        				}else
        				if(casert!=0){
        					if(playt_s[nowplaywhich]*2==casert)casert=-1;//符合结束条件
        					else
        					{
        						if(nowplaywhich==1){
        							if(90*2==casert)playzhongbeginzhuan(3);
        							if(190*2==casert)playzhongbeginzhuan(4);
        						}
        						if(nowplaywhich==2){
        							if(25*2==casert)playzhongbeginzhuan(6);
        							if(55*2==casert)playzhongbeginzhuan(7);
        							if(140*2==casert)playzhongbeginzhuan(8);
        						}
        						if(nowplaywhich==3){
        							if(32*2==casert)playzhongbeginzhuan(10);
        							if(170*2==casert)playzhongbeginzhuan(11);
        						}
        						if(nowplaywhich==4){
        							if(105*2==casert)playzhongbeginzhuan(13);
        							if(130*2==casert)playzhongbeginzhuan(14);
        						}
        						if(nowplaywhich==5){
        							if(130*2==casert)playzhongbeginzhuan(16);
        							if(185*2==casert)playzhongbeginzhuan(17);
        						}
        					}
        						
        				}
        				casert++;
        			}
        			if(upneedmove){
        				upmovet++;
        				upmovev=w*(21-upmovet)/200;upmovex+=upmovev;
                      	playpictrueup.setX(w*40/40-upmovex-w);
                      	if(upmovet==20){upneedmove=false;}
        			}
                    if(caser==-1){
                    	casert++;if (casert==20)casert=1;
                    	if(casert<=10){
                    	h1=h*(100+casert)/100/4;w1=h*6*(100-casert)/100/4/5;
                    	}
                    	else
                    	{
                    	h1=h*(100+20-casert)/100/4;w1=h*6*(100-20+casert)/100/4/5;	
                    	}
                    	button1.setX(w/2-w1/2);
                    	button1.setY(h/4-h1/2);
                    	//==================在java里设置imageView的宽高        	
                    	lp=button1.getLayoutParams();
                    	lp.width=w1;
                    	lp.height=h1; 
                    	button1.setLayoutParams(lp);
                        //===========================================】
                    }
                    //】
                    //caser_2
                    if(caser==-2){
                    	casert++;if (casert==40){casert=16;}//<15&&>10

                    	//{粒子位置}【
                    	huax[1]=w/2;
                        huay[1]=0;
                        hua[1].setX(huax[1]);
                        hua[1].setY(huay[1]);
                    	//】
                        
                        //{教程箭头闪烁}【
                        if(casert>=16&&casert<=36)arrow.setAlpha(12*(casert-15));
                        //】
                    	
                    	if(beautiful_buying==0&&casert<=15){//不可到15
                    		moneytext.setText(" "+wj_money*casert/15);
                    		if(wj_buytrue[1]==0)knifetext.setText(" "+wj_sell[1]*casert/15);
                    		if(wj_buytrue[2]==0)zhitext.setText(" "+wj_sell[2]*casert/15);
                    		if(wj_buytrue[3]==0)xitext.setText(" "+wj_sell[3]*casert/15);
                    		if(wj_buytrue[4]==0)yuntext.setText(" "+wj_sell[4]*casert/15);
                    		if(wj_buytrue[5]==0)guangtext.setText(" "+wj_sell[5]*casert/15);
                    	}
                    	
                    	if(beautiful_buying==1&&casert<=15){
                    		moneytext.setText(" "+(wj_money+wj_sell[1]*(15-casert)/15));
                    		if(casert==1)moneytext.setTextColor(Color.parseColor("#FFFFFF"));
                    		if(casert==15)moneytext.setTextColor(Color.parseColor("#0006FF"));
                    		
                    		beautiful_buyingt++;int bei=beautiful_buyingt;//easy write
                    		if(bei==1||bei==6||bei==10||bei==13||bei==15){knife.setVisibility(View.VISIBLE);knifetext.setVisibility(View.VISIBLE);}
                    		else{knife.setVisibility(View.INVISIBLE);knifetext.setVisibility(View.INVISIBLE);}
                    	}
                    	if(beautiful_buying==2&&casert<=15){
                    		moneytext.setText(" "+(wj_money+wj_sell[2]*(15-casert)/15));
                    		if(casert==1)moneytext.setTextColor(Color.parseColor("#FFFFFF"));
                    		if(casert==15)moneytext.setTextColor(Color.parseColor("#0006FF"));
                    		
                    		beautiful_buyingt++;int bei=beautiful_buyingt;//easy write
                    		if(bei==1||bei==6||bei==10||bei==13||bei==15){zhi.setVisibility(View.VISIBLE);zhitext.setVisibility(View.VISIBLE);}
                    		else{zhi.setVisibility(View.INVISIBLE);zhitext.setVisibility(View.INVISIBLE);}
                    	}
                    	if(beautiful_buying==3&&casert<=15){
                    		moneytext.setText(" "+(wj_money+wj_sell[3]*(15-casert)/15));
                    		if(casert==1)moneytext.setTextColor(Color.parseColor("#FFFFFF"));
                    		if(casert==15)moneytext.setTextColor(Color.parseColor("#0006FF"));
                    		
                    		beautiful_buyingt++;int bei=beautiful_buyingt;//easy write
                    		if(bei==1||bei==6||bei==10||bei==13||bei==15){xi.setVisibility(View.VISIBLE);xitext.setVisibility(View.VISIBLE);}
                    		else{xi.setVisibility(View.INVISIBLE);xitext.setVisibility(View.INVISIBLE);}
                    	}
                    	if(beautiful_buying==4&&casert<=15){
                    		moneytext.setText(" "+(wj_money+wj_sell[4]*(15-casert)/15));
                    		if(casert==1)moneytext.setTextColor(Color.parseColor("#FFFFFF"));
                    		if(casert==15)moneytext.setTextColor(Color.parseColor("#0006FF"));
                    		
                    		beautiful_buyingt++;int bei=beautiful_buyingt;//easy write
                    		if(bei==1||bei==6||bei==10||bei==13||bei==15){yun.setVisibility(View.VISIBLE);yuntext.setVisibility(View.VISIBLE);}
                    		else{yun.setVisibility(View.INVISIBLE);yuntext.setVisibility(View.INVISIBLE);}
                    	}
                    	if(beautiful_buying==5&&casert<=15){
                    		moneytext.setText(" "+(wj_money+wj_sell[5]*(15-casert)/15));
                    		if(casert==1)moneytext.setTextColor(Color.parseColor("#FFFFFF"));
                    		if(casert==15)moneytext.setTextColor(Color.parseColor("#0006FF"));
                    		
                    		beautiful_buyingt++;int bei=beautiful_buyingt;//easy write
                    		if(bei==1||bei==6||bei==10||bei==13||bei==15){guang.setVisibility(View.VISIBLE);guangtext.setVisibility(View.VISIBLE);}
                    		else{guang.setVisibility(View.INVISIBLE);guangtext.setVisibility(View.INVISIBLE);}
                    	}
            
                    	//按钮变大：begin  
                    	 if(casert<=30&&casert>15){
                    		    if(casert<=22)w2=h*(casert+5)/17/20;else w2=h*(50-casert)/17/20;//h2=h*(casert-15+5)/12/20;w2=h2;;
                    		    
                    			chuangguan.setX(w*3/4-w2);
                    			chuangguan.setY(17*h/18-w2);
                    			//==================在java里设置imageView的宽高        	
                    			lp=chuangguan.getLayoutParams();
                    			lp.width=w2*2;
                    			lp.height=w2*2; 
                    			chuangguan.setLayoutParams(lp);
                    			//===========================================】
                    			
                    			//==================在java里设置imageView的宽高        	
                    			lp=jia1.getLayoutParams();
                    			lp.width=w2;
                    			lp.height=w2; 
                    			jia1.setLayoutParams(lp);
                    			//===========================================】
                    			jia1.setX(w*6/7-w2/2-h/18);
                    			jia1.setY(3*h/10-w2/2);
                    			
                    			//==================在java里设置imageView的宽高        	
                    			lp=jia2.getLayoutParams();
                    			lp.width=w2;
                    			lp.height=w2; 
                    			jia2.setLayoutParams(lp);
                    			//===========================================】
                    			jia2.setX(w*6/7-w2/2-h/18);
                    			jia2.setY(4*h/10-w2/2);
                    			
                    			//==================在java里设置imageView的宽高        	
                    			lp=jia3.getLayoutParams();
                    			lp.width=w2;
                    			lp.height=w2; 
                    			jia3.setLayoutParams(lp);
                    			//===========================================】
                    			jia3.setX(w*6/7-w2/2-h/18);
                    			jia3.setY(5*h/10-w2/2);

                    			//==================在java里设置imageView的宽高        	
                    			lp=jia4.getLayoutParams();
                    			lp.width=w2;
                    			lp.height=w2; 
                    			jia4.setLayoutParams(lp);
                    			//===========================================】
                    			jia4.setX(w*6/7-w2/2-h/18);
                    			jia4.setY(6*h/10-w2/2);

                    			//==================在java里设置imageView的宽高
                    			lp=jia5.getLayoutParams();
                    			lp.width=w2;
                    			lp.height=w2; 
                    			jia5.setLayoutParams(lp);
                    			//===========================================】
                    			jia5.setX(w*6/7-w2/2-h/18);
                    			jia5.setY(7*h/10-w2/2);
                    	 } 
                    	 //end
                    	
                    }
                    //】
   
                  //caser10
                    if(caser==10){
                    	casert++;
                    	if(casert==1){
                    		lp=txtpictrue.getLayoutParams();
                    		lp.width=w*5/6;
                    		//lp.height=h/2; 
                    		txtpictrue.setLayoutParams(lp);
                    		//===========================================】
                    		txtpictrue.setX(w/12);
                    		txtpictrue.setY(h/30);
                    		txtpictrue.setVisibility(View.VISIBLE);
                    	}
                    	if(casert<=20){
                    		//匀减速直线运动的游戏背景
                    		 v1=w*(21-casert)/200;x1+=v1;
                         	gamebackground.setX(w*43/40-x1);
                    	}
                    	if(casert<=60&&casert>20){
                      		if(casert<=30)h1=h*(casert)/20/20;else
                      		if(casert<=40)h1=h*(60-casert)/20/20;else
                      		if(casert<=50)h1=h*(casert-20)/20/20;else
                      		h1=h*(80-casert)/20/20;	
                    		//chuangguan.setVisibility(View.VISIBLE);
                    		//==================在java里设置imageView的宽高        	
                    		lp=chuangguan.getLayoutParams();
                    		lp.width=h1;
                    		lp.height=h1; 
                    		chuangguan.setLayoutParams(lp);
                    		//===========================================】
                    		//chuangguan.setX(w*7/8-h1/2);
                    		//chuangguan.setY(h*17/18-h1/2);
                    		
                    		//knife.setVisibility(View.VISIBLE);
                    		//==================在java里设置imageView的宽高        	
                    		lp=knife.getLayoutParams();
                    		lp.width=h1;
                    		lp.height=h1; 
                    		knife.setLayoutParams(lp);
                    		//===========================================】
                    		//knife.setX(w*1/8-h1/2);
                    		//knife.setY(h*15/18-h1/2);
                    		
                    		//zhi.setVisibility(View.VISIBLE);
                    		//==================在java里设置imageView的宽高        	
                    		lp=zhi.getLayoutParams();
                    		lp.width=h1;
                    		lp.height=h1; 
                    		zhi.setLayoutParams(lp);
                    		//===========================================】
                    		//zhi.setX(w*3/8-h1/2);
                    		//zhi.setY(h*15/18-h1/2);
                    		
                    		//xi.setVisibility(View.VISIBLE);
                    		//==================在java里设置imageView的宽高        	
                    		lp=xi.getLayoutParams();
                    		lp.width=h1;
                    		lp.height=h1; 
                    		xi.setLayoutParams(lp);
                    		//===========================================】
                    		//xi.setX(w*5/8-h1/3);
                    		//xi.setY(h*15/18-h1/2);
                    		
                    		//yun.setVisibility(View.VISIBLE);
                    		//==================在java里设置imageView的宽高        	
                    		lp=yun.getLayoutParams();
                    		lp.width=h1;
                    		lp.height=h1; 
                    		yun.setLayoutParams(lp);
                    		//===========================================】
                    		//yun.setX(w*7/8-h1/2);
                    		//yun.setY(h*15/18-h1/2);
                    		
                    		
                    		//guang.setVisibility(View.VISIBLE);
                    		//==================在java里设置imageView的宽高        	
                    		lp=guang.getLayoutParams();
                    		lp.width=h1;
                    		lp.height=h1; 
                    		guang.setLayoutParams(lp);
                    		//===========================================】
                    		//guang.setX(w*5/8-h1/2);
                    		//guang.setY(h*17/18-h1/2);

                    		chuangguan.setX(w*3/4-h1/2);
                    		chuangguan.setY(h*17/18-h1/2);

                    		knife.setX(w/4-h1/2);
                    		knife.setY(h*15/18-h1/2);

                    		zhi.setX(w/2-h1/2);
                    		zhi.setY(h*15/18-h1/2);

                    		xi.setX(w*3/4-h1/3);
                    		xi.setY(h*15/18-h1/2);

                    		yun.setX(w/4-h1/2);
                    		yun.setY(h*17/18-h1/2);

                    		guang.setX(w/2-h1/2);
                    		guang.setY(h*17/18-h1/2);
                    	}
                    	if(casert==21){
                    		appearguan();
                    	}
                    	if(casert>21)//{教程箭头闪烁}【
                    		//arrow.setY(h/2+casert-21);
                            arrow.setAlpha(250);//setAlpha(12*(casert-21));
                            //】
                    	if(casert==32){casert=22;}
                    }
                    //】
                    //caser21-25
                    if(caser>=21&&caser<=25){
                    	casert++;
                    	if(casert<=20){
                    		i1.setAlpha(casert*12);
                    		directionbutton1.setAlpha(casert*12);
                    		directionbutton2.setAlpha(casert*12);
                    		directionbutton3.setAlpha(casert*12);
                    	}
                    	if(casert<=30&&casert>20){
                    		if(casert<=25){
                    			directionbutton1.setAlpha((casert-20)*51);
                        		directionbutton2.setAlpha((casert-20)*51);
                        		directionbutton3.setAlpha((casert-20)*51);
                    		}
                    		if(casert>25){
                    			directionbutton1.setAlpha((31-casert)*51);
                        		directionbutton2.setAlpha((31-casert)*51);
                        		directionbutton3.setAlpha((31-casert)*51);
                    		}
                    	}	
                    	if(casert>19)//{教程箭头闪烁}【
                            arrow.setAlpha(250);//arrow.setAlpha(12*(casert-19));
                            //】
                    	if(casert==30)casert=20;
                    }
                    //】
                  //caser28
                    if(caser==28){
                    	casert++;
                    	if(casert<=20)i1.setAlpha(casert*12);
                    	if(casert==40){
                    		talktext.setVisibility(View.INVISIBLE);
                    		txtpictrue.setVisibility(View.INVISIBLE);
                    		guanpictrue.setVisibility(View.INVISIBLE);
                    		brownpaper.setVisibility(View.INVISIBLE);
                    		i1.setVisibility(View.INVISIBLE);
                    	}
                    	if(casert<=60&&casert>40){
                    		notebackground.setAlpha((casert-40)*12);
                    		//{成功失败字部分}【
                    		if(casert==41){
                    			succeedorfail.setVisibility(View.VISIBLE);
                    			if(win)soundpool.play(soundmap.get(5+wj_dengjiorguan-1), 1, 1, 0, 0,1);
                    			if(win)soundpool.play(soundmap.get(5), 1, 1, 0, 0,1);
                    			if(win)succeedorfail.setImageResource(R.drawable.succeed);else succeedorfail.setImageResource(R.drawable.fail);
                    		}
                    		
                    		int wsf=w*(65-casert)/3/5;
                    		//==================在java里设置imageView的宽高        	
                    		lp=succeedorfail.getLayoutParams();
                    		lp.width=wsf;
                    		lp.height=wsf/2; 
                    		succeedorfail.setLayoutParams(lp);
                    		//===========================================】
                    		succeedorfail.setX(w/2-wsf/2);
                    		succeedorfail.setY(h*22/48-wsf/4);
                    		//】
                    	}
                    	if(casert==60){
                    		
                    		//txtpictrue.setVisibility(View.VISIBLE);
                    		//==================在java里设置imageView的宽高        	
                    		lp=txtpictrue.getLayoutParams();
                    		lp.width=w*5/6;
                    		//lp.height=h/2; 
                    		txtpictrue.setLayoutParams(lp);
                    		//===========================================】
                    		txtpictrue.setX(w/12);
                    		txtpictrue.setY(h/2);
                    		txtpictrue.setVisibility(View.VISIBLE);
                     if(win){
                            if(wj_dengjiorguan-1==1)txtpictrue.setImageResource(R.drawable.praisepictrue1);
                            if(wj_dengjiorguan-1==2)txtpictrue.setImageResource(R.drawable.praisepictrue9);
                            if(wj_dengjiorguan-1==3)txtpictrue.setImageResource(R.drawable.praisepictrue17);
                            if(wj_dengjiorguan-1==4)txtpictrue.setImageResource(R.drawable.praisepictrue2);
                            if(wj_dengjiorguan-1==5)txtpictrue.setImageResource(R.drawable.praisepictrue3);
                            if(wj_dengjiorguan-1==6)txtpictrue.setImageResource(R.drawable.praisepictrue16);
                            if(wj_dengjiorguan-1==7)txtpictrue.setImageResource(R.drawable.praisepictrue4);
                            if(wj_dengjiorguan-1==8)txtpictrue.setImageResource(R.drawable.praisepictrue5);
                            if(wj_dengjiorguan-1==9)txtpictrue.setImageResource(R.drawable.praisepictrue21);
                            if(wj_dengjiorguan-1==10)txtpictrue.setImageResource(R.drawable.praisepictrue6);
                            if(wj_dengjiorguan-1==11)txtpictrue.setImageResource(R.drawable.praisepictrue7);
                            if(wj_dengjiorguan-1==12)txtpictrue.setImageResource(R.drawable.praisepictrue8);
                            if(wj_dengjiorguan-1==13)txtpictrue.setImageResource(R.drawable.praisepictrue18);
                            if(wj_dengjiorguan-1==14)txtpictrue.setImageResource(R.drawable.praisepictrue10);
                            if(wj_dengjiorguan-1==15)txtpictrue.setImageResource(R.drawable.praisepictrue20);
                            if(wj_dengjiorguan-1==16)txtpictrue.setImageResource(R.drawable.praisepictrue11);
                            if(wj_dengjiorguan-1==17)txtpictrue.setImageResource(R.drawable.praisepictrue19);
                            if(wj_dengjiorguan-1==18)txtpictrue.setImageResource(R.drawable.praisepictrue12);
                            if(wj_dengjiorguan-1==19)txtpictrue.setImageResource(R.drawable.praisepictrue15);
                            if(wj_dengjiorguan-1==20)txtpictrue.setImageResource(R.drawable.praisepictrue13);
                            if(wj_dengjiorguan-1==21)txtpictrue.setImageResource(R.drawable.praisepictrue14);

                          //==================在java里设置imageView的宽高        	
                    		lp=talktext.getLayoutParams();
                    		lp.width=w*5/6;
                    		//lp.height=h/2; 
                    		talktext.setLayoutParams(lp);
                    		//===========================================】
                    		talktext.setX(w/2-w/12);
                    		talktext.setY(h/4);
                    		talktext.setVisibility(View.VISIBLE);
                    		talktext.setText("+ "+((wj_dengjiorguan-1)*30));
                    		talktext.setTextSize(30);//高度，h/18失控，->30
                    		talktext.setTextColor(Color.parseColor("#FFFFFF"));
                    		
                    		money.setVisibility(View.VISIBLE);
                    		money.setX(w/2+w/10);
                    		money.setY(h/4);
                    			}
                    		else if(! win)
                    		{
                    			txtpictrue.setVisibility(View.INVISIBLE);
                    			
                    			if(failtime[wj_dengjiorguan]==1){
                    				txtpictrue.setVisibility(View.VISIBLE);
                    			//if(wj_dengjiorguan-1==1)txtpictrue.setImageResource(R.drawable.praisepictrue1);
                                if(wj_dengjiorguan==2)txtpictrue.setImageResource(R.drawable.failteacher2);
                                if(wj_dengjiorguan==3)txtpictrue.setImageResource(R.drawable.failteacher3);
                                if(wj_dengjiorguan==4)txtpictrue.setImageResource(R.drawable.failteacher4);
                                if(wj_dengjiorguan==5)txtpictrue.setImageResource(R.drawable.failteacher5);
                                if(wj_dengjiorguan==6)txtpictrue.setImageResource(R.drawable.failteacher6);
                                if(wj_dengjiorguan==7)txtpictrue.setImageResource(R.drawable.failteacher7);
                                if(wj_dengjiorguan==8)txtpictrue.setImageResource(R.drawable.failteacher8);
                                if(wj_dengjiorguan==9)txtpictrue.setImageResource(R.drawable.failteacher9);
                                if(wj_dengjiorguan==10)txtpictrue.setImageResource(R.drawable.failteacher10);
                                if(wj_dengjiorguan==11)txtpictrue.setImageResource(R.drawable.failteacher11);
                                if(wj_dengjiorguan==12)txtpictrue.setImageResource(R.drawable.failteacher12);
                                if(wj_dengjiorguan==13)txtpictrue.setImageResource(R.drawable.failteacher13);
                                if(wj_dengjiorguan==14)txtpictrue.setImageResource(R.drawable.failteacher14);
                                if(wj_dengjiorguan==15)txtpictrue.setImageResource(R.drawable.failteacher15);
                                if(wj_dengjiorguan==16)txtpictrue.setImageResource(R.drawable.failteacher161718);
                                if(wj_dengjiorguan==17)txtpictrue.setImageResource(R.drawable.failteacher161718);
                                if(wj_dengjiorguan==18)txtpictrue.setImageResource(R.drawable.failteacher161718);
                                if(wj_dengjiorguan==19)txtpictrue.setImageResource(R.drawable.failteacher19);
                                if(wj_dengjiorguan==20)txtpictrue.setImageResource(R.drawable.failteacher20);
                                if(wj_dengjiorguan==21)txtpictrue.setImageResource(R.drawable.failteacher21);
                    			}
                    		}
                    	}
                    	if(casert==70&&failtime[wj_dengjiorguan]==0&& ! win){

                    	    setplaywhat();
                    		closecaser28();
                    		opencaser_3();
                    		failtime[wj_dengjiorguan]=1;
                    	}
                    	if(casert==130&&win){closecaser28();opencaser_2();}
                    	if(casert==150&&!win){closecaser28();opencaser_2();}
                    	if(casert==1132)casert=1131;
                    }
                    //】
                  //caser30
                    if(caser==30){
                    	casert++;
                    	if(casert<=40){
                    		
                    		//notebackground.setAlpha(casert*4);
                    		//tree.setAlpha(casert*4);
                    		tree.setAlpha(250);
                    		//==================在java里设置imageView的宽高        	
        					lp=tree.getLayoutParams();
        					lp.width=casert*w/40;
        					lp.height=casert*h/40; 
        					tree.setLayoutParams(lp);
        					//===========================================】
        					tree.setY(h-casert*h/40);
        					tree.setX(w/2-casert*w/80);
                    		
                    	}
                    	if(casert==50){closecaser30();opencaser_1();}
                    }
                    //】
                    //guanshow
                    if(guanshow==1){
                    	guanshowt++;
                    	if(guanshowt<=20){
                    		i1.setAlpha(guanshowt*12);
                    		leftsun.setAlpha(guanshowt*12);
                    		rightsun.setAlpha(guanshowt*12);
                    	}
                    	if(guanshowt==50){guanshowt=21;}
                    }
                    //】
                  //noteshow
                    if(noteshow==1){
                    	noteshowt++;
                    	if(noteshowt<=14){
                    		if(noteshowt<=7)w4=(w)*(noteshowt+33)/40;else w4=(w)*(47-noteshowt)/40;
                    		
                    		//==================在java里设置imageView的宽高        	
        					lp=notebackground.getLayoutParams();
        					lp.width=w4;
        					lp.height=w4*7/10; 
        					notebackground.setLayoutParams(lp);
        					//===========================================】
        					notebackground.setX(w/2-w4/2);
        					notebackground.setY(h/2-w4*7/20);
                    	}
                    	if(noteshowt==15)talktext.setVisibility(View.VISIBLE);
                    	if(noteshowt==50){noteshowt=21;}
                    }
                    if(noteshow==0){
                    	noteshowt++;
                    	if(noteshowt<=14){
                    		if(noteshowt<=7)w4=(w)*(noteshowt+33)/40;else w4=(w)*(47-noteshowt)/40;
                    		
                    		//==================在java里设置imageView的宽高        	
        					lp=notebackground.getLayoutParams();
        					lp.width=w4;
        					lp.height=w4*7/10; 
        					notebackground.setLayoutParams(lp);
        					//===========================================】
        					notebackground.setX(w/2-w4/2);
        					notebackground.setY(h/2-w4*7/20);
                    	}
                    	if(noteshowt==15){notebackground.setVisibility(View.INVISIBLE);}
                    	if(noteshowt==50){noteshowt=21;}
                    }
                    //】
                   
        		}
        	super.handleMessage(msg);	
        	}
       };
       Thread t=new Thread(new Runnable(){
       	@Override
       	public void run(){
       		while(!Thread.currentThread().isInterrupted()){
       			Message m=handler.obtainMessage();
       			m.what=0x101;
       			//======write or no
       			handler.sendMessage(m);
       			try{Thread.sleep(50);}catch(InterruptedException e){e.printStackTrace();}
       		}
       	}
       });
       t.start();
    }


void opencaser_1(){
    wj_dengjiorguan=1;
    wj_money=100;
    wj_sell[1]=0;
    wj_sell[2]=100;
    wj_sell[3]=150;
    wj_sell[4]=300;
    wj_sell[5]=3600;
    wj_buytrue[1]=0;
    wj_buytrue[2]=0;
    wj_buytrue[3]=0;
    wj_buytrue[4]=0;
    wj_buytrue[5]=0;
    
    aimright[1]=0;
    aimright[2]=1;
    aimright[3]=0;
    aimright[4]=1;
    aimright[5]=0;
    aimright[6]=0;
    aimright[7]=-1;
    aimright[8]=1;
    aimright[9]=0;
    aimright[10]=0;
    aimright[11]=1;
    aimright[12]=0;
    aimright[13]=1;
    aimright[14]=1;
    aimright[15]=0;
    aimright[16]=0;
    aimright[17]=0;
    aimright[18]=-1;
    aimright[19]=1;
    aimright[20]=0;
    aimright[21]=1;
    
    playt_s[0]=100;//十分之一秒
    playt_s[1]=240;
    playt_s[2]=165;
    playt_s[3]=350;
    playt_s[4]=230;
    playt_s[5]=250;
    
    for (failtimei=1;failtimei<=21;failtimei++){
    	failtime[failtimei]=0;
    }
    
    playi=6;
    playl[1]=0;
    playl[2]=1;
    playl[3]=2;
    playl[4]=3;
    playl[5]=4;
    playl[6]=5;
	
    beautiful_buying=0;
    guanshow=0;//w
    noteshow=0;
    teacheredcaser=0;
    upneedmove=false;
	
	caser=-1;casert=0;
	button1.setVisibility(View.VISIBLE);
    h1=h/4;w1=h1*6/5;
	button1.setX(w/2-w1/2);
	button1.setY(h/4-h1/2);
	//==================在java里设置imageView的宽高        	
	lp=button1.getLayoutParams();
	lp.width=w1;
	lp.height=h1; 
	button1.setLayoutParams(lp);
    //===========================================】
	
	firstsay.setVisibility(View.VISIBLE);
	firstsay.setX(0);
	firstsay.setY(h*13/24);
	//==================在java里设置imageView的宽高        	
	lp=firstsay.getLayoutParams();
	lp.width=w;
	lp.height=w/3; 
	firstsay.setLayoutParams(lp);
    //===========================================】
	
	
}
 void closecaser_1(){
	 caser=0;button1.setVisibility(View.INVISIBLE);
	 firstsay.setVisibility(View.INVISIBLE);
 }   
 void opencaser_2(){
	 caser=-2;casert=0;
	 
	 beautiful_buyingt=0;
	 
	    if(wj_dengjiorguan==1)plantcaser=0;
		if(wj_dengjiorguan==2)plantcaser=0;
		if(wj_dengjiorguan==3)plantcaser=0;
		if(wj_dengjiorguan==4)plantcaser=0;
		if(wj_dengjiorguan==5)plantcaser=0;
		if(wj_dengjiorguan==6)plantcaser=0;
		if(wj_dengjiorguan==7)plantcaser=0;
		if(wj_dengjiorguan==8)plantcaser=32;
		if(wj_dengjiorguan==9)plantcaser=0;
		if(wj_dengjiorguan==10)plantcaser=48;
		if(wj_dengjiorguan==11)plantcaser=64;
		if(wj_dengjiorguan==12)plantcaser=128;
		if(wj_dengjiorguan==13)plantcaser=48;
		if(wj_dengjiorguan==14)plantcaser=80;
		if(wj_dengjiorguan==15)plantcaser=224;
		if(wj_dengjiorguan==16)plantcaser=320;
		if(wj_dengjiorguan==17)plantcaser=240;
		if(wj_dengjiorguan==18)plantcaser=32;
		if(wj_dengjiorguan==19)plantcaser=0;
		if(wj_dengjiorguan==20)plantcaser=0;
		if(wj_dengjiorguan==21)plantcaser=0;
		
		if(wj_dengjiorguan==1)surroundings=4;
		if(wj_dengjiorguan==2)surroundings=4;
		if(wj_dengjiorguan==3)surroundings=4;
		if(wj_dengjiorguan==4)surroundings=12;
		if(wj_dengjiorguan==5)surroundings=4;
		if(wj_dengjiorguan==6)surroundings=12;
		if(wj_dengjiorguan==7)surroundings=0;
		if(wj_dengjiorguan==8)surroundings=4;
		if(wj_dengjiorguan==9)surroundings=4;
		if(wj_dengjiorguan==10)surroundings=4;
		if(wj_dengjiorguan==11)surroundings=4;
		if(wj_dengjiorguan==12)surroundings=4;
		if(wj_dengjiorguan==13)surroundings=4;
		if(wj_dengjiorguan==14)surroundings=4;
		if(wj_dengjiorguan==15)surroundings=4;
		if(wj_dengjiorguan==16)surroundings=12;
		if(wj_dengjiorguan==17)surroundings=0;
		if(wj_dengjiorguan==18)surroundings=4;
		if(wj_dengjiorguan==19)surroundings=4;
		if(wj_dengjiorguan==20)surroundings=4;
		if(wj_dengjiorguan==21)surroundings=0;
	 
	 dengji.setVisibility(View.VISIBLE);
	 dengji.setX(h/18);
	 dengji.setY(h/18);
	//==================在java里设置imageView的宽高        	
		lp=dengji.getLayoutParams();
		lp.width=h/18;
		lp.height=h/18; 
		dengji.setLayoutParams(lp);
	//===========================================】
		
    money.setVisibility(View.VISIBLE);
	money.setX(w/2);
	money.setY(h/18);
	//==================在java里设置imageView的宽高        	
	lp=money.getLayoutParams();
	lp.width=h/18;
	lp.height=h/18; 
	money.setLayoutParams(lp);
	//===========================================】
	
	chuangguan.setVisibility(View.VISIBLE);
    w2=1;h2=1;
	chuangguan.setX(w*3/4-w2/2);
	chuangguan.setY(17*h/18-h2/2);
	//==================在java里设置imageView的宽高        	
	lp=chuangguan.getLayoutParams();
	lp.width=w2;
	lp.height=h2; 
	chuangguan.setLayoutParams(lp);
	//===========================================】
	
	knife.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=knife.getLayoutParams();
	lp.width=h/18;
	lp.height=h/18; 
	knife.setLayoutParams(lp);
	//===========================================】
	knife.setX(w*4/7-h/36-h/18-h/9);
	knife.setY(3*h/10-h/36);
	
	zhi.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=zhi.getLayoutParams();
	lp.width=h/18;
	lp.height=h/18; 
	zhi.setLayoutParams(lp);
	//===========================================】
	zhi.setX(w*4/7-h/36-h/18-h/9);
	zhi.setY(4*h/10-h/36);
	
	xi.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=xi.getLayoutParams();
	lp.width=h/18;
	lp.height=h/18; 
	xi.setLayoutParams(lp);
	//===========================================】
	xi.setX(w*4/7-h/36-h/18-h/9);
	xi.setY(5*h/10-h/36);
	
	yun.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=yun.getLayoutParams();
	lp.width=h/18;
	lp.height=h/18; 
	yun.setLayoutParams(lp);
	//===========================================】
	yun.setX(w*4/7-h/36-h/18-h/9);
	yun.setY(6*h/10-h/36);
	
	guang.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=guang.getLayoutParams();
	lp.width=h/18;
	lp.height=h/18; 
	guang.setLayoutParams(lp);
	//===========================================】
	guang.setX(w*4/7-h/36-h/18-h/9);
	guang.setY(7*h/10-h/36);
	
	if(wj_money>=wj_sell[1]||wj_buytrue[1]==1)jia1.setVisibility(View.VISIBLE);
	if(wj_buytrue[1]==1)jia1.setImageResource(R.drawable.wen);else jia1.setImageResource(R.drawable.jia);
	//==================在java里设置imageView的宽高        	
	lp=jia1.getLayoutParams();
	lp.width=h/18;
	lp.height=h/18; 
	jia1.setLayoutParams(lp);
	//===========================================】
	jia1.setX(w*6/7-h/36-h/18);
	jia1.setY(3*h/10-h/36);
	
	if(wj_money>=wj_sell[2]||wj_buytrue[2]==1)jia2.setVisibility(View.VISIBLE);
	if(wj_buytrue[2]==1)jia2.setImageResource(R.drawable.wen);else jia2.setImageResource(R.drawable.jia);
	//==================在java里设置imageView的宽高        	
	lp=jia2.getLayoutParams();
	lp.width=h/18;
	lp.height=h/18; 
	jia2.setLayoutParams(lp);
	//===========================================】
	jia2.setX(w*6/7-h/36-h/18);
	jia2.setY(4*h/10-h/36);
	
	if(wj_money>=wj_sell[3]||wj_buytrue[3]==1)jia3.setVisibility(View.VISIBLE);
	if(wj_buytrue[3]==1)jia3.setImageResource(R.drawable.wen);else jia3.setImageResource(R.drawable.jia);
	//==================在java里设置imageView的宽高        	
	lp=jia3.getLayoutParams();
	lp.width=h/18;
	lp.height=h/18; 
	jia3.setLayoutParams(lp);
	//===========================================】
	jia3.setX(w*6/7-h/36-h/18);
	jia3.setY(5*h/10-h/36);
	
	if(wj_money>=wj_sell[4]||wj_buytrue[4]==1)jia4.setVisibility(View.VISIBLE);
	if(wj_buytrue[4]==1)jia4.setImageResource(R.drawable.wen);else jia4.setImageResource(R.drawable.jia);
	//==================在java里设置imageView的宽高        	
	lp=jia4.getLayoutParams();
	lp.width=h/18;
	lp.height=h/18; 
	jia4.setLayoutParams(lp);
	//===========================================】
	jia4.setX(w*6/7-h/36-h/18);
	jia4.setY(6*h/10-h/36);
	
	if(wj_money>=wj_sell[5]||wj_buytrue[5]==1)jia5.setVisibility(View.VISIBLE);
	if(wj_buytrue[5]==1)jia5.setImageResource(R.drawable.wen);else jia5.setImageResource(R.drawable.jia);
	//==================在java里设置imageView的宽高        	
	lp=jia5.getLayoutParams();
	lp.width=h/18;
	lp.height=h/18; 
	jia5.setLayoutParams(lp);
	//===========================================】
	jia5.setX(w*6/7-h/36-h/18);
	jia5.setY(7*h/10-h/36);
	

	
	dengjitext.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=dengjitext.getLayoutParams();
	lp.width=h/9;
	lp.height=h/18; 
	dengjitext.setLayoutParams(lp);
	//===========================================】
	dengjitext.setX(h/9);
	dengjitext.setY(h/18);
	dengjitext.setText(" "+wj_dengjiorguan);
	dengjitext.setTextSize(30);
	dengjitext.setTextColor(Color.parseColor("#FFFFFF"));
	
	moneytext.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=moneytext.getLayoutParams();
	lp.width=w;
	lp.height=h/18; 
	moneytext.setLayoutParams(lp);
	//===========================================】
	moneytext.setX(w/2+h/18);
	moneytext.setY(h/18);
	moneytext.setText(" "+wj_money);
	moneytext.setTextSize(30);
	moneytext.setTextColor(Color.parseColor("#0006FF"));
	
	knifetext.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=knifetext.getLayoutParams();
	lp.width=w/2;
	lp.height=h/18; 
	knifetext.setLayoutParams(lp);
	//===========================================】
	knifetext.setX(w*4/7-h/36-h/9);
	knifetext.setY(3*h/10-h/36);
	knifetext.setText(" "+wj_sell[1]);
	knifetext.setTextSize(30);
	knifetext.setTextColor(Color.parseColor("#FF6600"));
	if(wj_buytrue[1]==1){
		knifetext.setText("已购买");
		knifetext.setTextColor(Color.parseColor("#00FF00"));
	}
	
	zhitext.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=zhitext.getLayoutParams();
	lp.width=w/2;
	lp.height=h/18; 
	zhitext.setLayoutParams(lp);
	//===========================================】
	zhitext.setX(w*4/7-h/36-h/9);
	zhitext.setY(4*h/10-h/36);
	zhitext.setText(" "+wj_sell[2]);
	zhitext.setTextSize(30);
	zhitext.setTextColor(Color.parseColor("#FF6600"));
	if(wj_buytrue[2]==1){
		zhitext.setText("已购买");
		zhitext.setTextColor(Color.parseColor("#00FF00"));
	}
	
	xitext.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=xitext.getLayoutParams();
	lp.width=w/2;
	lp.height=h/18; 
	xitext.setLayoutParams(lp);
	//===========================================】
	xitext.setX(w*4/7-h/36-h/9);
	xitext.setY(5*h/10-h/36);
	xitext.setText(" "+wj_sell[3]);
	xitext.setTextSize(30);
	xitext.setTextColor(Color.parseColor("#FF6600"));
	if(wj_buytrue[3]==1){
		xitext.setText("已购买");
		xitext.setTextColor(Color.parseColor("#00FF00"));
	}
	
	yuntext.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=yuntext.getLayoutParams();
	lp.width=w/2;
	lp.height=h/18; 
	yuntext.setLayoutParams(lp);
	//===========================================】
	yuntext.setX(w*4/7-h/36-h/9);
	yuntext.setY(6*h/10-h/36);
	yuntext.setText(" "+wj_sell[4]);
	yuntext.setTextSize(30);
	yuntext.setTextColor(Color.parseColor("#FF6600"));
	if(wj_buytrue[4]==1){
		yuntext.setText("已购买");
		yuntext.setTextColor(Color.parseColor("#00FF00"));
	}
	
	guangtext.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=guangtext.getLayoutParams();
	lp.width=w/2;
	lp.height=h/18; 
	guangtext.setLayoutParams(lp);
	//===========================================】
	guangtext.setX(w*4/7-h/36-h/9);
	guangtext.setY(7*h/10-h/36);
	guangtext.setText(" "+wj_sell[5]);
	guangtext.setTextSize(30);
	guangtext.setTextColor(Color.parseColor("#FF6600"));
	if(wj_buytrue[5]==1){
		guangtext.setText("已购买");
		guangtext.setTextColor(Color.parseColor("#00FF00"));
	}
	
	//w3h3
    int huai;
    for(huai=1;huai<=8;huai++){
    hua[huai].setVisibility(View.VISIBLE);	
    huax[huai]=w/2;
    huay[huai]=0;
    hua[huai].setX(huax[huai]);
    hua[huai].setY(huay[huai]);
    if(huai==1){
        //==================在java里设置imageView的宽高        	
  	    lp=hua[huai].getLayoutParams();
  	    lp.width=h/36;
  	    lp.height=h/72; 
  	    hua[huai].setLayoutParams(lp);
  	    //===========================================】
        }
    if(huai==2&&huai==3){
        //==================在java里设置imageView的宽高        	
      	lp=hua[huai].getLayoutParams();
      	lp.width=h/72;
      	lp.height=h/72; 
      	hua[huai].setLayoutParams(lp);
      	//===========================================】
        }
    if(huai==4&&huai==5){
        //==================在java里设置imageView的宽高        	
      	lp=hua[huai].getLayoutParams();
      	lp.width=h/72;
      	lp.height=h/144; 
      	hua[huai].setLayoutParams(lp);
      	//===========================================】
        }
    if(huai==6&&huai==7&&huai==8){
        //==================在java里设置imageView的宽高        	
      	lp=hua[huai].getLayoutParams();
      	lp.width=h/144;
      	lp.height=h/144; 
      	hua[huai].setLayoutParams(lp);
      	//===========================================】
        }
    }
    
    if(teacheredcaser==0){
    	arrow.setVisibility(View.VISIBLE);
     	arrow.setX(w/2+h/9);
	    arrow.setY(h/3-h*3/40);
	    //==================在java里设置imageView的宽高        	
	    lp=arrow.getLayoutParams();
	    lp.width=h/8;
	    lp.height=h/8; 
    	arrow.setLayoutParams(lp);
	//===========================================】
    
    	halfsee.setVisibility(View.VISIBLE);
    	halfsee.setImageResource(R.drawable.half0_1);
     	halfsee.setX(0);
	    halfsee.setY(0);
	    //==================在java里设置imageView的宽高        	
	    lp=halfsee.getLayoutParams();
	    lp.width=w;
	    lp.height=h; 
    	halfsee.setLayoutParams(lp);
	//===========================================】
    }
    if(teacheredcaser==1){
    	arrow.setVisibility(View.VISIBLE);
     	arrow.setX(w/2+h/9);
	    arrow.setY(h/5+h/6);
	    //==================在java里设置imageView的宽高        	
	    lp=arrow.getLayoutParams();
	    lp.width=h/8;
	    lp.height=h/8; 
    	arrow.setLayoutParams(lp);
	//===========================================】
    	
    	halfsee.setVisibility(View.VISIBLE);
    	halfsee.setImageResource(R.drawable.half1_2);
     	halfsee.setX(0);
	    halfsee.setY(0);
	    //==================在java里设置imageView的宽高        	
	    lp=halfsee.getLayoutParams();
	    lp.width=w;
	    lp.height=h; 
    	halfsee.setLayoutParams(lp);
	//===========================================】
    }
    if(teacheredcaser==2){
    	arrow.setVisibility(View.VISIBLE);
     	arrow.setX(w/2+h/9);
	    arrow.setY(h/3-h*3/40);
	    //==================在java里设置imageView的宽高        	
	    lp=arrow.getLayoutParams();
	    lp.width=h/8;
	    lp.height=h/8; 
    	arrow.setLayoutParams(lp);
	//===========================================】
    	
    	halfsee.setVisibility(View.VISIBLE);
    	halfsee.setImageResource(R.drawable.half2_3);
     	halfsee.setX(0);
	    halfsee.setY(0);
	    //==================在java里设置imageView的宽高        	
	    lp=halfsee.getLayoutParams();
	    lp.width=w;
	    lp.height=h; 
    	halfsee.setLayoutParams(lp);
	//===========================================】
    }
    
    
 }
void closecaser_2(){
	beautiful_buying=0;//加号必定改beautiful_buying,chuangguan必定关caser_2
	
	caser=0;
	dengji.setVisibility(View.INVISIBLE);
	dengjitext.setVisibility(View.INVISIBLE);
	money.setVisibility(View.INVISIBLE);
	moneytext.setVisibility(View.INVISIBLE);
	knife.setVisibility(View.INVISIBLE);
	zhi.setVisibility(View.INVISIBLE);
	xi.setVisibility(View.INVISIBLE);
	yun.setVisibility(View.INVISIBLE);
	guang.setVisibility(View.INVISIBLE);
	knifetext.setVisibility(View.INVISIBLE);
	zhitext.setVisibility(View.INVISIBLE);
	xitext.setVisibility(View.INVISIBLE);
	yuntext.setVisibility(View.INVISIBLE);
	guangtext.setVisibility(View.INVISIBLE);
	jia1.setVisibility(View.INVISIBLE);
	jia2.setVisibility(View.INVISIBLE);
	jia3.setVisibility(View.INVISIBLE);
	jia4.setVisibility(View.INVISIBLE);
	jia5.setVisibility(View.INVISIBLE);
	chuangguan.setVisibility(View.INVISIBLE);
	hua[1].setVisibility(View.INVISIBLE);
    hua[2].setVisibility(View.INVISIBLE);
    hua[3].setVisibility(View.INVISIBLE);
    hua[4].setVisibility(View.INVISIBLE);
    hua[5].setVisibility(View.INVISIBLE);
    hua[6].setVisibility(View.INVISIBLE);
    hua[7].setVisibility(View.INVISIBLE);
    hua[8].setVisibility(View.INVISIBLE);
    talktext.setVisibility(View.INVISIBLE);
    notebackground.setVisibility(View.INVISIBLE);
}
void opencaser10(){
	caser=10;casert=0;
	txtpictrue.setY(h/30);
	/*txtpictrue.setVisibility(View.VISIBLE);
	txtpictrue.setX(0);
	txtpictrue.setY(0);
	//==================在java里设置imageView的宽高        	
	lp=txtpictrue.getLayoutParams();
	lp.width=w;
	lp.height=h*7/18; 
	txtpictrue.setLayoutParams(lp);*/
    //===========================================】
	
	brownpaper.setVisibility(View.VISIBLE);
	brownpaper.setX(0);
	brownpaper.setY(0);
	//==================在java里设置imageView的宽高        	
	lp=brownpaper.getLayoutParams();
	lp.width=w;
	lp.height=h*7/18; 
	brownpaper.setLayoutParams(lp);
    //===========================================】
	

		settimu();
	
	x1=0;
	gamebackground.setVisibility(View.VISIBLE);
	gamebackground.setX(w*43/40);
	gamebackground.setY(h*7/18);
	//==================在java里设置imageView的宽高        	
	lp=gamebackground.getLayoutParams();
	lp.width=w*9/10;
	lp.height=h*7*9/18/10; 
	gamebackground.setLayoutParams(lp);
    //===========================================】
	
	buttonbackground.setVisibility(View.VISIBLE);
	buttonbackground.setX(0);
	buttonbackground.setY(h*7/9);
	//==================在java里设置imageView的宽高        	
	lp=buttonbackground.getLayoutParams();
	lp.width=w;
	lp.height=h*2/9; 
	buttonbackground.setLayoutParams(lp);
    //===========================================】
	
	h1=h/20;//[
	
	chuangguan.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=chuangguan.getLayoutParams();
	lp.width=h1;
	lp.height=h1; 
	chuangguan.setLayoutParams(lp);
	//===========================================】
	chuangguan.setX(w*3/4-h1/2);
	chuangguan.setY(h*17/18-h1/2);
	
	if(wj_buytrue[1]==1)knife.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=knife.getLayoutParams();
	lp.width=h1;
	lp.height=h1; 
	knife.setLayoutParams(lp);
	//===========================================】
	knife.setX(w/4-h1/2);
	knife.setY(h*15/18-h1/2);
	
	if(wj_buytrue[2]==1)zhi.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=zhi.getLayoutParams();
	lp.width=h1;
	lp.height=h1; 
	zhi.setLayoutParams(lp);
	//===========================================】
	zhi.setX(w/2-h1/2);
	zhi.setY(h*15/18-h1/2);
	
	if(wj_buytrue[3]==1)xi.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=xi.getLayoutParams();
	lp.width=h1;
	lp.height=h1; 
	xi.setLayoutParams(lp);
	//===========================================】
	xi.setX(w*3/4-h1/3);
	xi.setY(h*15/18-h1/2);
	
	if(wj_buytrue[4]==1)yun.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=yun.getLayoutParams();
	lp.width=h1;
	lp.height=h1; 
	yun.setLayoutParams(lp);
	//===========================================】
	yun.setX(w/4-h1/2);
	yun.setY(h*17/18-h1/2);
	
	
	if(wj_buytrue[5]==1)guang.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=guang.getLayoutParams();
	lp.width=h1;
	lp.height=h1; 
	guang.setLayoutParams(lp);
	//===========================================】
	guang.setX(w/2-h1/2);
	guang.setY(h*17/18-h1/2);
	//]
	

}
void closecaser10(){
	caser=0;
	
	brownpaper.setVisibility(View.INVISIBLE);
	gamebackground.setVisibility(View.INVISIBLE);
	buttonbackground.setVisibility(View.INVISIBLE);
	chuangguan.setVisibility(View.INVISIBLE);
	knife.setVisibility(View.INVISIBLE);
	zhi.setVisibility(View.INVISIBLE);
	xi.setVisibility(View.INVISIBLE);
	yun.setVisibility(View.INVISIBLE);
	guang.setVisibility(View.INVISIBLE);
	talktext.setVisibility(View.INVISIBLE);
	guanpictrue.setVisibility(View.INVISIBLE);
	txtpictrue.setVisibility(View.INVISIBLE);
	
	disappearguan();
}
void appearguan(){
	guanshow=1;guanshowt=0;
	
	if(plantcaser==0)i1.setImageResource(R.drawable.i0);else
	if(plantcaser==2)i1.setImageResource(R.drawable.i2);else
	if(plantcaser==6)i1.setImageResource(R.drawable.i6);else
	if(plantcaser==10)i1.setImageResource(R.drawable.i10);else
	if(plantcaser==16)i1.setImageResource(R.drawable.i16);else
	if(plantcaser==32)i1.setImageResource(R.drawable.i32);else
	if(plantcaser==64)i1.setImageResource(R.drawable.i64);else
	if(plantcaser==128)i1.setImageResource(R.drawable.i128);else
	if(plantcaser==256)i1.setImageResource(R.drawable.i256);else
	if(plantcaser==14)i1.setImageResource(R.drawable.i14);else
	if(plantcaser==48)i1.setImageResource(R.drawable.i48);else
	if(plantcaser==80)i1.setImageResource(R.drawable.i80);else
	if(plantcaser==144)i1.setImageResource(R.drawable.i144);else
	if(plantcaser==272)i1.setImageResource(R.drawable.i272);else
	if(plantcaser==96)i1.setImageResource(R.drawable.i96);else
	if(plantcaser==160)i1.setImageResource(R.drawable.i160);else
	if(plantcaser==288)i1.setImageResource(R.drawable.i288);else
	if(plantcaser==192)i1.setImageResource(R.drawable.i192);else
	if(plantcaser==320)i1.setImageResource(R.drawable.i320);else
	if(plantcaser==384)i1.setImageResource(R.drawable.i384);else
	if(plantcaser==176)i1.setImageResource(R.drawable.i176);else
	if(plantcaser==304)i1.setImageResource(R.drawable.i304);else
	if(plantcaser==112)i1.setImageResource(R.drawable.i112);else
	if(plantcaser==208)i1.setImageResource(R.drawable.i208);else
	if(plantcaser==336)i1.setImageResource(R.drawable.i336);else
	if(plantcaser==400)i1.setImageResource(R.drawable.i400);else
	if(plantcaser==224)i1.setImageResource(R.drawable.i224);else
	if(plantcaser==352)i1.setImageResource(R.drawable.i352);else
	if(plantcaser==416)i1.setImageResource(R.drawable.i416);else
	if(plantcaser==448)i1.setImageResource(R.drawable.i448);else
	if(plantcaser==240)i1.setImageResource(R.drawable.i240);else
	if(plantcaser==368)i1.setImageResource(R.drawable.i368);else
	if(plantcaser==432)i1.setImageResource(R.drawable.i432);else
	if(plantcaser==464)i1.setImageResource(R.drawable.i464);else
	if(plantcaser==480)i1.setImageResource(R.drawable.i480);else
	if(plantcaser==496)i1.setImageResource(R.drawable.i496);else
		i1.setImageResource(R.drawable.upbutton);
	
	i1.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=i1.getLayoutParams();
	lp.width=h*7/36/4;
	lp.height=h*7/36; 
	i1.setLayoutParams(lp);
	//===========================================】
	i1.setX(w/2-h*7/36/4/2);
	i1.setY(h*17/30-h*7/36/2);
	i1.setAlpha(0);
	
	//leftsun.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=leftsun.getLayoutParams();
	lp.width=h/10;
	lp.height=h/10; 
	leftsun.setLayoutParams(lp);
	//===========================================】
	leftsun.setX(w/4-h/20);
	leftsun.setY(h/2-h/20);
	leftsun.setAlpha(0);
	
	//rightsun.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=rightsun.getLayoutParams();
	lp.width=h/10;
	lp.height=h/10; 
	rightsun.setLayoutParams(lp);
	//===========================================】
	rightsun.setX(w*3/4-h/20);
	rightsun.setY(h/2-h/20);
	rightsun.setAlpha(0);
	
	int sur=surroundings;
	if(surroundings>=8){surroundings-=8;rightsun.setVisibility(View.VISIBLE);}else rightsun.setVisibility(View.INVISIBLE); 
	if(surroundings>=4){surroundings-=4;leftsun.setVisibility(View.VISIBLE);}else leftsun.setVisibility(View.INVISIBLE);
	surroundings=sur;
}
void disappearguan(){//不是完全关闭
	guanshow=0;
	
	i1.setVisibility(View.INVISIBLE);	
	leftsun.setVisibility(View.INVISIBLE);
	rightsun.setVisibility(View.INVISIBLE);

}
void opencaser21(){
	caser=21;casert=0;

	i1.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=i1.getLayoutParams();
	lp.width=h*7/36/2;
	lp.height=h*7/18; 
	i1.setLayoutParams(lp);
	//===========================================】
	i1.setX(w/2-h*7/36/4);
	i1.setY(h*17/30-h*7/36);
	i1.setAlpha(0);
	
	directionbutton1.setVisibility(View.VISIBLE);
	directionbutton1.setImageResource(R.drawable.rightbutton);
	//==================在java里设置imageView的宽高        	
	lp=directionbutton1.getLayoutParams();
	lp.width=h*7/36;
	lp.height=h*7/36/3; 
	directionbutton1.setLayoutParams(lp);
	//===========================================】
	directionbutton1.setX(w/4-h*7/77);
	directionbutton1.setY(h/2);
	directionbutton1.setAlpha(0);
}
void closecaser21(){
	caser=0;
	i1.setVisibility(View.INVISIBLE);
	directionbutton1.setVisibility(View.INVISIBLE);
}
void opencaser22(){
	caser=22;casert=0;

	
	
	i1.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=i1.getLayoutParams();
	lp.width=h*7/36/2;
	lp.height=h*7/18; 
	i1.setLayoutParams(lp);
	//===========================================】
	i1.setX(w/2-h*7/36/4);
	i1.setY(h*17/30-h*7/36);
	i1.setAlpha(0);
	
	directionbutton1.setVisibility(View.VISIBLE);
	directionbutton1.setImageResource(R.drawable.rightbutton);
	//==================在java里设置imageView的宽高        	
	lp=directionbutton1.getLayoutParams();
	lp.width=h*7/36;
	lp.height=h*7/36/3; 
	directionbutton1.setLayoutParams(lp);
	//===========================================】
	directionbutton1.setX(w/4-h*7/77);
	directionbutton1.setY(h/2-h*7/36/3);
	directionbutton1.setAlpha(0);
	
	directionbutton2.setVisibility(View.VISIBLE);
	directionbutton2.setImageResource(R.drawable.leftbutton);
	//==================在java里设置imageView的宽高        	
	lp=directionbutton2.getLayoutParams();
	lp.width=h*7/36;
	lp.height=h*7/36/3; 
	directionbutton2.setLayoutParams(lp);
	//===========================================】
	directionbutton2.setX(w*3/4-h*7/77);
	directionbutton2.setY(h/2-h*7/36/3);
	directionbutton2.setAlpha(0);
}
void closecaser22(){
	caser=0;
	i1.setVisibility(View.INVISIBLE);
	directionbutton1.setVisibility(View.INVISIBLE);
	directionbutton2.setVisibility(View.INVISIBLE);
}
void opencaser23(){
	caser=23;casert=0;

	i1.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=i1.getLayoutParams();
	lp.width=h*7/36/2;
	lp.height=h*7/18; 
	i1.setLayoutParams(lp);
	//===========================================】
	i1.setX(w/2-h*7/36/4);
	i1.setY(h*17/30-h*7/36);
	i1.setAlpha(0);
	
	directionbutton1.setVisibility(View.VISIBLE);
	directionbutton1.setImageResource(R.drawable.rightbutton);
	//==================在java里设置imageView的宽高        	
	lp=directionbutton1.getLayoutParams();
	lp.width=h*7/36;
	lp.height=h*7/36/3; 
	directionbutton1.setLayoutParams(lp);
	//===========================================】
	directionbutton1.setX(w/4-h*7/77);
	directionbutton1.setY(h/2-h*7/36/3);
	directionbutton1.setAlpha(0);
	
	directionbutton2.setVisibility(View.VISIBLE);
	directionbutton2.setImageResource(R.drawable.leftbutton);
	//==================在java里设置imageView的宽高        	
	lp=directionbutton2.getLayoutParams();
	lp.width=h*7/36;
	lp.height=h*7/36/3; 
	directionbutton2.setLayoutParams(lp);
	//===========================================】
	directionbutton2.setX(w*3/4-h*7/77);
	directionbutton2.setY(h/2-h*7/36/3);
	directionbutton2.setAlpha(0);
}
void closecaser23(){
	caser=0;
	i1.setVisibility(View.INVISIBLE);
	directionbutton1.setVisibility(View.INVISIBLE);
	directionbutton2.setVisibility(View.INVISIBLE);
}
void opencaser24(){
	caser=24;casert=0;

	i1.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=i1.getLayoutParams();
	lp.width=h*7/36/2;
	lp.height=h*7/18; 
	i1.setLayoutParams(lp);
	//===========================================】
	i1.setX(w/2-h*7/36/4);
	i1.setY(h*17/30-h*7/36);
	i1.setAlpha(0);
	
	directionbutton1.setVisibility(View.VISIBLE);
	directionbutton1.setImageResource(R.drawable.rightbutton);
	//==================在java里设置imageView的宽高        	
	lp=directionbutton1.getLayoutParams();
	lp.width=h*7/36;
	lp.height=h*7/36/3; 
	directionbutton1.setLayoutParams(lp);
	//===========================================】
	directionbutton1.setX(w/4-h*7/77);
	directionbutton1.setY(h/2-h*7/36/3);
	directionbutton1.setAlpha(0);
	
	directionbutton2.setVisibility(View.VISIBLE);
	directionbutton2.setImageResource(R.drawable.leftbutton);
	//==================在java里设置imageView的宽高        	
	lp=directionbutton2.getLayoutParams();
	lp.width=h*7/36;
	lp.height=h*7/36/3; 
	directionbutton2.setLayoutParams(lp);
	//===========================================】
	directionbutton2.setX(w*3/4-h*7/77);
	directionbutton2.setY(h/2-h*7/36/3);
	directionbutton2.setAlpha(0);
	
	directionbutton3.setVisibility(View.VISIBLE);
	directionbutton3.setImageResource(R.drawable.downbutton);
	//==================在java里设置imageView的宽高        	
	lp=directionbutton3.getLayoutParams();
	lp.width=h*7/36/3;
	lp.height=h*7/36; 
	directionbutton3.setLayoutParams(lp);
	//===========================================】
	directionbutton3.setX(w/2-h*7/36/6);
	directionbutton3.setY(h/4);
	directionbutton3.setAlpha(0);
}
void closecaser24(){
	caser=0;
	i1.setVisibility(View.INVISIBLE);
	directionbutton1.setVisibility(View.INVISIBLE);
	directionbutton2.setVisibility(View.INVISIBLE);
	directionbutton3.setVisibility(View.INVISIBLE);
}
void opencaser25(){
	caser=25;casert=0;


	
	directionbutton1.setVisibility(View.VISIBLE);
	directionbutton1.setImageResource(R.drawable.rightbutton);
	//==================在java里设置imageView的宽高        	
	lp=directionbutton1.getLayoutParams();
	lp.width=h*7/36;
	lp.height=h*7/36/3; 
	directionbutton1.setLayoutParams(lp);
	//===========================================】
	directionbutton1.setX(w/4-h*7/77);
	directionbutton1.setY(h/2-h*7/36/3);
	directionbutton1.setAlpha(0);
	
	directionbutton2.setVisibility(View.VISIBLE);
	directionbutton2.setImageResource(R.drawable.leftbutton);
	//==================在java里设置imageView的宽高        	
	lp=directionbutton2.getLayoutParams();
	lp.width=h*7/36;
	lp.height=h*7/36/3; 
	directionbutton2.setLayoutParams(lp);
	//===========================================】
	directionbutton2.setX(w*3/4-h*7/77);
	directionbutton2.setY(h/2-h*7/36/3);
	directionbutton2.setAlpha(0);
	

}
void closecaser25(){
	caser=0;
	//i1.setVisibility(View.INVISIBLE);
	directionbutton1.setVisibility(View.INVISIBLE);
	directionbutton2.setVisibility(View.INVISIBLE);
	//directionbutton3.setVisibility(View.INVISIBLE);
}

void opencaser28(){
	txtpictrue.setY(h/30);
	
	soundpool.play(soundmap.get(1), 1, 1, 0, 0,1);
	
    caser=28;casert=0;
	
	brownpaper.setVisibility(View.VISIBLE);
	brownpaper.setX(0);
	brownpaper.setY(0);
	//==================在java里设置imageView的宽高        	
	lp=brownpaper.getLayoutParams();
	lp.width=w;
	lp.height=h*7/18; 
	brownpaper.setLayoutParams(lp);
    //===========================================】
	
	gamebackground.setVisibility(View.VISIBLE);
	gamebackground.setX(w*43/40);
	gamebackground.setY(h*7/18);
	//==================在java里设置imageView的宽高        	
	lp=gamebackground.getLayoutParams();
	lp.width=w*9/10;
	lp.height=h*7*9/18/10; 
	gamebackground.setLayoutParams(lp);
    //===========================================】
	
	boolean upsunhave,downsunhave,leftsunhave,rightsunhave;
	int sunhave;
	sunhave=surroundings;
	if(sunhave>=8){sunhave-=8;rightsunhave=true;}else rightsunhave=false;
	if(sunhave>=4){sunhave-=4;leftsunhave=true;}else leftsunhave=false;
	if(sunhave>=2){sunhave-=2;downsunhave=true;}else downsunhave=false;
	if(sunhave>=1){sunhave-=1;upsunhave=true;}else upsunhave=false;
	
	//int finalright;
	
	if(plantcaser==0&&leftsunhave&&rightsunhave==false){i1.setImageResource(R.drawable.left0);finalright=-1;}
	if(plantcaser==0&&rightsunhave&&leftsunhave==false){i1.setImageResource(R.drawable.right0);finalright=1;}
	if(plantcaser==0&&leftsunhave==false&&rightsunhave==false){i1.setImageResource(R.drawable.i0);finalright=0;}
	if(plantcaser==0&&leftsunhave&&rightsunhave){i1.setImageResource(R.drawable.i0);finalright=0;}
	if(plantcaser==2){i1.setImageResource(R.drawable.i2);finalright=0;}
	if(plantcaser==6){i1.setImageResource(R.drawable.right6);finalright=1;}
	if(plantcaser==10){i1.setImageResource(R.drawable.left10);finalright=-1;}
	if(plantcaser==16&&rightsunhave){i1.setImageResource(R.drawable.right16);finalright=1;}
	if(plantcaser==16&&rightsunhave==false){i1.setImageResource(R.drawable.i16);finalright=0;}
	if(plantcaser==32&&leftsunhave){i1.setImageResource(R.drawable.left32);finalright=-1;}
	if(plantcaser==32&&leftsunhave==false){i1.setImageResource(R.drawable.i32);finalright=0;}
	if(plantcaser==64){i1.setImageResource(R.drawable.i64);finalright=0;}
	if(plantcaser==128){i1.setImageResource(R.drawable.left128);finalright=-1;}
	if(plantcaser==256){i1.setImageResource(R.drawable.right256);finalright=1;}
	if(plantcaser==14){i1.setImageResource(R.drawable.i14);finalright=0;}
	if(plantcaser==48){i1.setImageResource(R.drawable.i48);finalright=0;}
	if(plantcaser==80){i1.setImageResource(R.drawable.i80);finalright=0;}
	if(plantcaser==144){i1.setImageResource(R.drawable.left144);finalright=-1;}
	if(plantcaser==272){i1.setImageResource(R.drawable.right272);finalright=1;}
	if(plantcaser==96){i1.setImageResource(R.drawable.i96);finalright=0;}
	if(plantcaser==160){i1.setImageResource(R.drawable.left160);finalright=-1;}
	if(plantcaser==288){i1.setImageResource(R.drawable.right288);finalright=1;}
	if(plantcaser==192){i1.setImageResource(R.drawable.left192);finalright=-1;}
	if(plantcaser==320){i1.setImageResource(R.drawable.right320);finalright=1;}
	if(plantcaser==384){i1.setImageResource(R.drawable.i384);finalright=0;}
	if(plantcaser==176){i1.setImageResource(R.drawable.left176);finalright=-1;}
	if(plantcaser==304){i1.setImageResource(R.drawable.right304);finalright=1;}
	if(plantcaser==112){i1.setImageResource(R.drawable.i112);finalright=0;}
	if(plantcaser==208){i1.setImageResource(R.drawable.left208);finalright=-1;}
	if(plantcaser==336){i1.setImageResource(R.drawable.right336);finalright=1;}
	if(plantcaser==400){i1.setImageResource(R.drawable.i400);finalright=0;}
	if(plantcaser==224){i1.setImageResource(R.drawable.left224);finalright=-1;}
	if(plantcaser==352){i1.setImageResource(R.drawable.right352);finalright=1;}
	if(plantcaser==416){i1.setImageResource(R.drawable.i416);finalright=0;}
	if(plantcaser==448){i1.setImageResource(R.drawable.i448);finalright=0;}
	if(plantcaser==240){i1.setImageResource(R.drawable.left240);finalright=-1;}
	if(plantcaser==368){i1.setImageResource(R.drawable.right368);finalright=1;}
	if(plantcaser==432){i1.setImageResource(R.drawable.i432);finalright=0;}
	if(plantcaser==464){i1.setImageResource(R.drawable.i464);finalright=0;}
	if(plantcaser==480){i1.setImageResource(R.drawable.i480);finalright=0;}
	if(plantcaser==496){i1.setImageResource(R.drawable.i496);finalright=0;}
	
	boolean plantcasers[]=new boolean[9];
	int plc=plantcaser;
	if (plc>=256){plc-=256;plantcasers[8]=true;}else plantcasers[8]=false;
	if (plc>=128){plc-=128;plantcasers[7]=true;}else plantcasers[7]=false;
	if (plc>=64){plc-=64;plantcasers[6]=true;}else plantcasers[6]=false;
	if (plc>=32){plc-=32;plantcasers[5]=true;}else plantcasers[5]=false;
	if (plc>=16){plc-=16;plantcasers[4]=true;}else plantcasers[4]=false;
	if (plc>=8){plc-=8;plantcasers[3]=true;}else plantcasers[3]=false;
	if (plc>=4){plc-=4;plantcasers[2]=true;}else plantcasers[2]=false;
	if (plc>=2){plc-=2;plantcasers[1]=true;}else plantcasers[1]=false;
	
	win=false;
	
	if(wj_dengjiorguan==1&&aimright[1]==finalright)win=true;
	if(wj_dengjiorguan==2&&aimright[2]==finalright)win=true;
	if(wj_dengjiorguan==3&&plantcasers[2]&&plantcasers[3]&&aimright[3]==finalright)win=true;
	if(wj_dengjiorguan==4&&plantcasers[1]==false&&aimright[4]==finalright)win=true;
	if(wj_dengjiorguan==5&&plantcasers[1]==false&&plantcasers[5]==false&&plantcasers[4]&&aimright[5]==finalright)win=true;
	if(wj_dengjiorguan==6&&plantcasers[1]==false&&aimright[6]==finalright)win=true;
	if(wj_dengjiorguan==7&&plantcasers[1]==false&&aimright[7]==finalright)win=true;
	if(wj_dengjiorguan==8&&plantcasers[1]==false&&aimright[8]==finalright)win=true;
	if(wj_dengjiorguan==9&&plantcasers[1]==false&&plantcasers[6]&&aimright[9]==finalright)win=true;
	if(wj_dengjiorguan==10&&plantcasers[1]==false&&plantcasers[6]&&aimright[10]==finalright)win=true;
	if(wj_dengjiorguan==11&&plantcasers[1]==false&&aimright[11]==finalright)win=true;
	if(wj_dengjiorguan==12&&plantcasers[1]==false&&aimright[12]==finalright)win=true;
	if(wj_dengjiorguan==13&&plantcasers[1]==false&&aimright[13]==finalright)win=true;
	if(wj_dengjiorguan==14&&plantcasers[1]==false&&aimright[14]==finalright)win=true;
	if(wj_dengjiorguan==15&&plantcasers[1]==false&&aimright[15]==finalright)win=true;
	if(wj_dengjiorguan==16&&plantcasers[1]==false&&aimright[16]==finalright)win=true;
	if(wj_dengjiorguan==17&&plantcasers[1]==false&&aimright[17]==finalright)win=true;
	if(wj_dengjiorguan==18&&plantcasers[1]==false&&aimright[18]==finalright)win=true;
	if(wj_dengjiorguan==19&&plantcasers[1]==false&&plantcasers[6]==false&&plantcasers[7]==false&&plantcasers[8]==false
			&&aimright[19]==finalright)win=true;
	if(wj_dengjiorguan==20&&plantcasers[1]==false&&plantcasers[6]==false&&plantcasers[7]==false&&plantcasers[8]==false
			&&aimright[20]==finalright)win=true;
	if(wj_dengjiorguan==21&&plantcasers[1]==false&&aimright[21]==finalright)win=true;
	
	//?=>1
	
	
	i1.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=i1.getLayoutParams();
	lp.width=h*7/36/4;
	lp.height=h*7/36; 
	i1.setLayoutParams(lp);
	//===========================================】
	i1.setX(w/2-h*7/36/4/2);
	i1.setY(h*17/30-h*7/36/2);
	i1.setAlpha(0);
	
	notebackground.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=notebackground.getLayoutParams();
	lp.width=w;
	lp.height=h*2/3; 
	notebackground.setLayoutParams(lp);
	//===========================================】
	notebackground.setX(0);
	notebackground.setY(h/6+h/30);
	notebackground.setAlpha(0);
	
    
	settimu();


	//?=>1
	if(win){
		wj_money+=30*wj_dengjiorguan;
		wj_dengjiorguan+=1;
		
	}else
	{
		wj_money+=wj_dengjiorguan;
	}
}
void closecaser28(){
	caser=0;
	brownpaper.setVisibility(View.INVISIBLE);
	gamebackground.setVisibility(View.INVISIBLE);
	i1.setVisibility(View.INVISIBLE);
	notebackground.setVisibility(View.INVISIBLE);
	txtpictrue.setVisibility(View.INVISIBLE);
	succeedorfail.setVisibility(View.INVISIBLE);
	talktext.setVisibility(View.INVISIBLE);
}
void opencaser30(){

	
	soundpool.play(soundmap.get(1), 1, 1, 0, 0,1);
	caser=30;casert=0;
	
	/*notebackground.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=notebackground.getLayoutParams();
	lp.width=w;
	lp.height=h/2; 
	notebackground.setLayoutParams(lp);
	//===========================================】
	notebackground.setX(0);
	notebackground.setY(h/4);
	notebackground.setAlpha(0);*/
	
    tree.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=tree.getLayoutParams();
	lp.width=w/2;
	lp.height=h/2/2; 
	tree.setLayoutParams(lp);
	//===========================================】
	tree.setX(0+w/4);
	tree.setY(h);
	tree.setAlpha(0);
	tree.setImageResource(R.drawable.tree);
}
void closecaser30(){
	caser=0;
	notebackground.setVisibility(View.INVISIBLE);
	talktext.setVisibility(View.INVISIBLE);
	tree.setVisibility(View.INVISIBLE);
}
void settimu(){
    /*talktext.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=talktext.getLayoutParams();
	lp.width=w/2;
	lp.height=h/2; 
	talktext.setLayoutParams(lp);
	//===========================================】
	talktext.setX(0+w/4);
	talktext.setY(h/6/3);
	//talktext.setAlpha(0);
	talktext.setTextSize(30);
	talktext.setTextColor(Color.parseColor("#FF6600"));

	
	if(wj_dengjiorguan==1)talktext.setText("                    1.直立生长                      ");
	if(wj_dengjiorguan==2)talktext.setText("                    2.向右弯曲");
	if(wj_dengjiorguan==3)talktext.setText("                    3.直立生长  要求要用琼脂块");
	if(wj_dengjiorguan==4)talktext.setText("                    4.不受刀伤  向右弯曲");
	if(wj_dengjiorguan==5)talktext.setText("                    5.不受刀伤  直立生长  要求只用一次工具");
	if(wj_dengjiorguan==6)talktext.setText("                    6.不受刀伤  直立生长");
	if(wj_dengjiorguan==7)talktext.setText("                    7.不受刀伤  向左弯曲");
	if(wj_dengjiorguan==8)talktext.setText("                    8.不受刀伤  向右弯曲");
	if(wj_dengjiorguan==9)talktext.setText("9.不受刀伤  直立生长  用且仅用一次云母片");
	if(wj_dengjiorguan==10)talktext.setText("10.不受刀伤  直立生长  用且仅用一次云母片");
	if(wj_dengjiorguan==11)talktext.setText("                   11.不受刀伤  向右弯曲");
	if(wj_dengjiorguan==12)talktext.setText("                   12.不受刀伤  直立生长");
	if(wj_dengjiorguan==13)talktext.setText("                   13.不受刀伤  向右弯曲");
	if(wj_dengjiorguan==14)talktext.setText("                   14.不受刀伤  向右弯曲");
	if(wj_dengjiorguan==15)talktext.setText("                   15.不受刀伤  直立生长");
	if(wj_dengjiorguan==16)talktext.setText("                   16.不受刀伤  直立生长");
	if(wj_dengjiorguan==17)talktext.setText("                   17.不受刀伤  直立生长");
	if(wj_dengjiorguan==18)talktext.setText("                   18.不受刀伤  向左弯曲");
	if(wj_dengjiorguan==19)talktext.setText("                   19.【不受伤】  向右弯曲");
	if(wj_dengjiorguan==20)talktext.setText("                   20.【不近距离操作】  直立生长");
	if(wj_dengjiorguan==21)talktext.setText("                   21.不受刀伤  向右弯曲");
	*/
	
	txtpictrue.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=txtpictrue.getLayoutParams();
	lp.width=w*4/6;
	//lp.height=h/2; 
	txtpictrue.setLayoutParams(lp);
	//===========================================】
	txtpictrue.setX(0+w/6);
	txtpictrue.setY(h/30);
	//txtpictrue.setScaleType(ImageView.ScaleType.FIT_XY);

	if(wj_dengjiorguan==1)txtpictrue.setImageResource(R.drawable.task1);
	if(wj_dengjiorguan==2)txtpictrue.setImageResource(R.drawable.task2);
	if(wj_dengjiorguan==3)txtpictrue.setImageResource(R.drawable.task3);
	if(wj_dengjiorguan==4)txtpictrue.setImageResource(R.drawable.task4);
	if(wj_dengjiorguan==5)txtpictrue.setImageResource(R.drawable.task5);
	if(wj_dengjiorguan==6)txtpictrue.setImageResource(R.drawable.task6);
	if(wj_dengjiorguan==7)txtpictrue.setImageResource(R.drawable.task7);
	if(wj_dengjiorguan==8)txtpictrue.setImageResource(R.drawable.task8);
	if(wj_dengjiorguan==9)txtpictrue.setImageResource(R.drawable.task9);
	if(wj_dengjiorguan==10)txtpictrue.setImageResource(R.drawable.task10);
	if(wj_dengjiorguan==11)txtpictrue.setImageResource(R.drawable.task11);
	if(wj_dengjiorguan==12)txtpictrue.setImageResource(R.drawable.task12);
	if(wj_dengjiorguan==13)txtpictrue.setImageResource(R.drawable.task13);
	if(wj_dengjiorguan==14)txtpictrue.setImageResource(R.drawable.task14);
	if(wj_dengjiorguan==15)txtpictrue.setImageResource(R.drawable.task15);
	if(wj_dengjiorguan==16)txtpictrue.setImageResource(R.drawable.task16);
	if(wj_dengjiorguan==17)txtpictrue.setImageResource(R.drawable.task17);
	if(wj_dengjiorguan==18)txtpictrue.setImageResource(R.drawable.task18);
	if(wj_dengjiorguan==19)txtpictrue.setImageResource(R.drawable.task19);
	if(wj_dengjiorguan==20)txtpictrue.setImageResource(R.drawable.task20);
	if(wj_dengjiorguan==21)txtpictrue.setImageResource(R.drawable.task21);
	
	
	guanpictrue.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=guanpictrue.getLayoutParams();
	lp.width=w/3;
	lp.height=w/6; 
	guanpictrue.setLayoutParams(lp);
	//===========================================】
	guanpictrue.setX(w/2-w/6);
	guanpictrue.setY(0);
	if(wj_dengjiorguan==1)guanpictrue.setImageResource(R.drawable.guan1);
	if(wj_dengjiorguan==2)guanpictrue.setImageResource(R.drawable.guan2);
	if(wj_dengjiorguan==3)guanpictrue.setImageResource(R.drawable.guan3);
	if(wj_dengjiorguan==4)guanpictrue.setImageResource(R.drawable.guan4);
	if(wj_dengjiorguan==5)guanpictrue.setImageResource(R.drawable.guan5);
	if(wj_dengjiorguan==6)guanpictrue.setImageResource(R.drawable.guan6);
	if(wj_dengjiorguan==7)guanpictrue.setImageResource(R.drawable.guan7);
	if(wj_dengjiorguan==8)guanpictrue.setImageResource(R.drawable.guan8);
	if(wj_dengjiorguan==9)guanpictrue.setImageResource(R.drawable.guan9);
	if(wj_dengjiorguan==10)guanpictrue.setImageResource(R.drawable.guan10);
	if(wj_dengjiorguan==11)guanpictrue.setImageResource(R.drawable.guan11);
	if(wj_dengjiorguan==12)guanpictrue.setImageResource(R.drawable.guan12);
	if(wj_dengjiorguan==13)guanpictrue.setImageResource(R.drawable.guan13);
	if(wj_dengjiorguan==14)guanpictrue.setImageResource(R.drawable.guan14);
	if(wj_dengjiorguan==15)guanpictrue.setImageResource(R.drawable.guan15);
	if(wj_dengjiorguan==16)guanpictrue.setImageResource(R.drawable.guan16);
	if(wj_dengjiorguan==17)guanpictrue.setImageResource(R.drawable.guan17);
	if(wj_dengjiorguan==18)guanpictrue.setImageResource(R.drawable.guan18);
	if(wj_dengjiorguan==19)guanpictrue.setImageResource(R.drawable.guan19);
	if(wj_dengjiorguan==20)guanpictrue.setImageResource(R.drawable.guan20);
	if(wj_dengjiorguan==21)guanpictrue.setImageResource(R.drawable.guan21);
}
void opencaser_3(){

	caser=-3;
	casert=0;
	
	tiaoguo.setVisibility(View.VISIBLE);
	//==================在java里设置imageView的宽高        	
	lp=tiaoguo.getLayoutParams();
	lp.width=w/5;
	lp.height=w/5; 
	tiaoguo.setLayoutParams(lp);
	//===========================================】
	tiaoguo.setX(0);
	tiaoguo.setY(h-w/5);
	
	//==================在java里设置imageView的宽高        	
	lp=playpictrueup.getLayoutParams();
	lp.width=w;
	lp.height=h; 
	playpictrueup.setLayoutParams(lp);
	//===========================================】
	playpictrueup.setX(0);
	playpictrueup.setY(0);
	playpictrueup.setVisibility(View.VISIBLE);
	
	//==================在java里设置imageView的宽高        	
		lp=playpictruedown.getLayoutParams();
		lp.width=w;
		lp.height=h; 
		playpictruedown.setLayoutParams(lp);
		//===========================================】
		playpictruedown.setX(0);
		playpictruedown.setY(0);
		playpictruedown.setVisibility(View.VISIBLE);		

		txtpictrue.setVisibility(View.VISIBLE);
		txtpictrue.setX(0);
		txtpictrue.setY(0);
		//==================在java里设置imageView的宽高        	
				lp=txtpictrue.getLayoutParams();
				lp.width=w;
				//lp.height=h; 
				txtpictrue.setLayoutParams(lp);
		//===========================================】	
}
void closecaser_3(){
	tiaoguo.setVisibility(View.INVISIBLE);
    playpictrueup.setVisibility(View.INVISIBLE);
    playpictruedown.setVisibility(View.INVISIBLE);
    txtpictrue.setVisibility(View.INVISIBLE);
	caser=0;
}
void setplaypictrueupbegin(int pi){
	if(pi==0)playzhongbeginzhuan(1);
	if(pi==1)playzhongbeginzhuan(2);
	if(pi==2)playzhongbeginzhuan(5);
	if(pi==3)playzhongbeginzhuan(9);
	if(pi==4)playzhongbeginzhuan(12);
	if(pi==5)playzhongbeginzhuan(15);

}
void playzhongbeginzhuan(int ki){
	upmovet=0;upneedmove=true;upmovex=0;
	//开始
	if(ki==1){
		playpictruedown.setImageResource(R.drawable.teacher1);
	    playpictrueup.setImageResource(R.drawable.teacher0);
	    txtpictrue.setImageResource(R.drawable.teachertxt0);
	}
	if(ki==2){
		playpictruedown.setImageResource(R.drawable.teacher2);
	    playpictrueup.setImageResource(R.drawable.teacher0);
	    txtpictrue.setImageResource(R.drawable.teachertxt1);
	}
	if(ki==5){
		playpictruedown.setImageResource(R.drawable.teacher5);
	    playpictrueup.setImageResource(R.drawable.teacher0);
	    txtpictrue.setImageResource(R.drawable.teachertxt2);
	}
	if(ki==9){
		playpictruedown.setImageResource(R.drawable.teacher9);
	    playpictrueup.setImageResource(R.drawable.teacher0);
	    txtpictrue.setImageResource(R.drawable.teachertxt3);
	}
	if(ki==12){
		playpictruedown.setImageResource(R.drawable.teacher12);
	    playpictrueup.setImageResource(R.drawable.teacher0);
	    txtpictrue.setImageResource(R.drawable.teachertxt4);
	}
	if(ki==15){
		playpictruedown.setImageResource(R.drawable.teacher15);
	    playpictrueup.setImageResource(R.drawable.teacher0);
	    txtpictrue.setImageResource(R.drawable.teachertxt5);
	}
	//中
	if(ki==3){
		playpictruedown.setImageResource(R.drawable.teacher3);
	    playpictrueup.setImageResource(R.drawable.teacher2);
	}
	if(ki==4){
		playpictruedown.setImageResource(R.drawable.teacher4);
	    playpictrueup.setImageResource(R.drawable.teacher3);
	}
	if(ki==6){
		playpictruedown.setImageResource(R.drawable.teacher6);
	    playpictrueup.setImageResource(R.drawable.teacher5);
	}
	if(ki==7){
		playpictruedown.setImageResource(R.drawable.teacher7);
	    playpictrueup.setImageResource(R.drawable.teacher6);
	}
	if(ki==8){
		playpictruedown.setImageResource(R.drawable.teacher8);
	    playpictrueup.setImageResource(R.drawable.teacher7);
	}
	if(ki==10){
		playpictruedown.setImageResource(R.drawable.teacher10);
	    playpictrueup.setImageResource(R.drawable.teacher9);
	}
	if(ki==11){
		playpictruedown.setImageResource(R.drawable.teacher11);
	    playpictrueup.setImageResource(R.drawable.teacher10);
	}
	if(ki==13){
		playpictruedown.setImageResource(R.drawable.teacher13);
	    playpictrueup.setImageResource(R.drawable.teacher12);
	}
	if(ki==14){
		playpictruedown.setImageResource(R.drawable.teacher14);
	    playpictrueup.setImageResource(R.drawable.teacher13);
	}
	if(ki==16){
		playpictruedown.setImageResource(R.drawable.teacher16);
	    playpictrueup.setImageResource(R.drawable.teacher15);
	}
	if(ki==17){
		playpictruedown.setImageResource(R.drawable.teacher17);
	    playpictrueup.setImageResource(R.drawable.teacher16);
	}
}
void setplaywhat(){
	/*playi=6;
    playl[1]=0;
    playl[2]=1;
    playl[3]=2;
    playl[4]=3;
    playl[5]=4;
    playl[6]=5;*/
    if(wj_dengjiorguan==2){
    	playi=2;
    	playl[1]=2;
    	playl[2]=3;
    }
    if(wj_dengjiorguan==3){
    	playi=2;
    	playl[1]=2;
    	playl[2]=3;
    }
    if(wj_dengjiorguan==4){
    	playi=1;
    	playl[1]=4;
    }
    if(wj_dengjiorguan==5){
    	playi=1;
    	playl[1]=4;
    }
    if(wj_dengjiorguan==6){
    	playi=1;
    	playl[1]=4;
    }
    if(wj_dengjiorguan==7&&wj_dengjiorguan==9&&wj_dengjiorguan==11&&wj_dengjiorguan==12&&wj_dengjiorguan==16){
    	playi=1;
    	playl[1]=5;
    }
    if(wj_dengjiorguan==8&&wj_dengjiorguan==10&&wj_dengjiorguan==13&&wj_dengjiorguan==14&&wj_dengjiorguan==15
    		&&wj_dengjiorguan==17&&wj_dengjiorguan==18){
    	playi=2;
    	playl[1]=4;
    	playl[2]=5;
    }
    if(wj_dengjiorguan==19){
    	playi=2;
    	playl[1]=4;
    	playl[2]=1;
    }
    if(wj_dengjiorguan==20){
    	playi=1;
    	playl[1]=1;
    }
    if(wj_dengjiorguan==21){
    	playi=2;
    	playl[1]=5;
    	playl[2]=1;
    }
}
}