package sgamerv.lifetool.categ.health;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class LifeToolActivity extends Activity {
	private ListView titleListPage;
    private View contenetPage;
    private TextView selectTitle;
    private TextView selectContent;
    private View navigatePanel;
    private ScrollView scrollContent;
    private View contentView;

    // Names of the photos we show in the list
    private static final String[] titles = new String[] {
            "润肺汤品齐来尝",
            "咳嗽西药慎重选",
            "黄芪牛肉防风寒",
            "过敏体质防病要点",
            "粗粮摄入要有限制",
            "鼻炎偏方不可信"
    };
    private static final String[] contents = new String[] {
        "1推荐食谱：清燥润肺老鸽汤 材料：鸽子500克，沙参20克，玉竹20克，麦冬15克，姜片5克，猪骨500克，盐少许。\n制法：1、将500克猪骨煲熟成汤，取2000克猪骨汤备用；\n2、将鸽子斩成四大块，放进开水锅内焯过，洗去血水，沥干待用；\n3、将沙参、玉竹、麦冬、姜片洗净，一同放进砂锅内，注入猪骨汤，加盖，用慢火煨约60分钟至肉熟汤浓，调味即成。/n推荐食谱：清燥润肺老鸽汤 材料：鸽子500克，沙参20克，玉竹20克，麦冬15克，姜片5克，猪骨500克，盐少许。制法：1、将500克猪骨煲熟成汤，取2000克猪骨汤备用；2、将鸽子斩成四大块，放进开水锅内焯过，洗去血水，沥干待用；3、将沙参、玉竹、麦冬、姜片洗净，一同放进砂锅内，注入猪骨汤，加盖，用慢火煨约60分钟至肉熟汤浓，调味即成。推荐食谱：清燥润肺老鸽汤 材料：鸽子500克，沙参20克，玉竹20克，麦冬15克，姜片5克，猪骨500克，盐少许。制法：1、将500克猪骨煲熟成汤，取2000克猪骨汤备用；2、将鸽子斩成四大块，放进开水锅内焯过，洗去血水，沥干待用；3、将沙参、玉竹、麦冬、姜片洗净，一同放进砂锅内，注入猪骨汤，加盖，用慢火煨约60分钟至肉熟汤浓，调味即成。推荐食谱：清燥润肺老鸽汤 材料：鸽子500克，沙参20克，玉竹20克，麦冬15克，姜片5克，猪骨500克，盐少许。制法：1、将500克猪骨煲熟成汤，取2000克猪骨汤备用；2、将鸽子斩成四大块，放进开水锅内焯过，洗去血水，沥干待用；3、将沙参、玉竹、麦冬、姜片洗净，一同放进砂锅内，注入猪骨汤，加盖，用慢火煨约60分钟至肉熟汤浓，调味即成。",
        "2推荐食谱：清燥润肺老鸽汤 材料：鸽子500克，沙参20克，玉竹20克，麦冬15克，姜片5克，猪骨500克，盐少许。制法：1、将500克猪骨煲熟成汤，取2000克猪骨汤备用；2、将鸽子斩成四大块，放进开水锅内焯过，洗去血水，沥干待用；3、将沙参、玉竹、麦冬、姜片洗净，一同放进砂锅内，注入猪骨汤，加盖，用慢火煨约60分钟至肉熟汤浓，调味即成。1推荐食谱：清燥润肺老鸽汤 材料：鸽子500克，沙参20克，玉竹20克，麦冬15克，姜片5克，猪骨500克，盐少许。\n制法：1、将500克猪骨煲熟成汤，取2000克猪骨汤备用；\n2、将鸽子斩成四大块，放进开水锅内焯过，洗去血水，沥干待用；\n3、将沙参、玉竹、麦冬、姜片洗净，一同放进砂锅内，注入猪骨汤，加盖，用慢火煨约60分钟至肉熟汤浓，调味即成。/n推荐食谱：清燥润肺老鸽汤 材料：鸽子500克，沙参20克，玉竹20克，麦冬15克，姜片5克，猪骨500克，盐少许。制法：1、将500克猪骨煲熟成汤，取2000克猪骨汤备用；2、将鸽子斩成四大块，放进开水锅内焯过，洗去血水，沥干待用；3、将沙参、玉竹、麦冬、姜片洗净，一同放进砂锅内，注入猪骨汤，加盖，用慢火煨约60分钟至肉熟汤浓，调味即成。推荐食谱：清燥润肺老鸽汤 材料：鸽子500克，沙参20克，玉竹20克，麦冬15克，姜片5克，猪骨500克，盐少许。制法：1、将500克猪骨煲熟成汤，取2000克猪骨汤备用；2、将鸽子斩成四大块，放进开水锅内焯过，洗去血水，沥干待用；3、将沙参、玉竹、麦冬、姜片洗净，一同放进砂锅内，注入猪骨汤，加盖，用慢火煨约60分钟至肉熟汤浓，调味即成。推荐食谱：清燥润肺老鸽汤 材料：鸽子500克，沙参20克，玉竹20克，麦冬15克，姜片5克，猪骨500克，盐少许。制法：1、将500克猪骨煲熟成汤，取2000克猪骨汤备用；2、将鸽子斩成四大块，放进开水锅内焯过，洗去血水，沥干待用；3、将沙参、玉竹、麦冬、姜片洗净，一同放进砂锅内，注入猪骨汤，加盖，用慢火煨约60分钟至肉熟汤浓，调味即成。",
        "3推荐食谱：清燥润肺老鸽汤 材料：鸽子500克，沙参20克，玉竹20克，麦冬15克，姜片5克，猪骨500克，盐少许。制法：1、将500克猪骨煲熟成汤，取2000克猪骨汤备用；2、将鸽子斩成四大块，放进开水锅内焯过，洗去血水，沥干待用；3、将沙参、玉竹、麦冬、姜片洗净，一同放进砂锅内，注入猪骨汤，加盖，用慢火煨约60分钟至肉熟汤浓，调味即成。",
        "4推荐食谱：清燥润肺老鸽汤 材料：鸽子500克，沙参20克，玉竹20克，麦冬15克，姜片5克，猪骨500克，盐少许。制法：1、将500克猪骨煲熟成汤，取2000克猪骨汤备用；2、将鸽子斩成四大块，放进开水锅内焯过，洗去血水，沥干待用；3、将沙参、玉竹、麦冬、姜片洗净，一同放进砂锅内，注入猪骨汤，加盖，用慢火煨约60分钟至肉熟汤浓，调味即成。",
        "5推荐食谱：清燥润肺老鸽汤 材料：鸽子500克，沙参20克，玉竹20克，麦冬15克，姜片5克，猪骨500克，盐少许。制法：1、将500克猪骨煲熟成汤，取2000克猪骨汤备用；2、将鸽子斩成四大块，放进开水锅内焯过，洗去血水，沥干待用；3、将沙参、玉竹、麦冬、姜片洗净，一同放进砂锅内，注入猪骨汤，加盖，用慢火煨约60分钟至肉熟汤浓，调味即成。",
        "6推荐食谱：清燥润肺老鸽汤 材料：鸽子500克，沙参20克，玉竹20克，麦冬15克，姜片5克，猪骨500克，盐少许。制法：1、将500克猪骨煲熟成汤，取2000克猪骨汤备用；2、将鸽子斩成四大块，放进开水锅内焯过，洗去血水，沥干待用；3、将沙参、玉竹、麦冬、姜片洗净，一同放进砂锅内，注入猪骨汤，加盖，用慢火煨约60分钟至肉熟汤浓，调味即成。"
};
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health);
        
        titleListPage = (ListView)findViewById(R.id.mylist);
        contenetPage = (View) findViewById(R.id.mainContent);
        selectTitle =(TextView) findViewById(R.id.myTitle);
        selectContent = (TextView) findViewById(R.id.myContent);
        navigatePanel = (View) findViewById(R.id.navigate);
        scrollContent = (ScrollView)findViewById(R.id.scrollContent);
        contentView  = (View)findViewById(R.id.contentView);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.list_item, titles);

        titleListPage.setAdapter(adapter);
        contenetPage.setRotationY(-90f);
        
        Button backbutton =(Button)findViewById(R.id.button);              
        backbutton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				flipitBack();				
			}
		});
        titleListPage.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
				scrollContent.scrollTo(0, 0);
				flipitTo(arg2);
			}
		});
        
    }
    
    private Interpolator accelerator = new AccelerateInterpolator();
    private Interpolator decelerator = new DecelerateInterpolator();
    private void flipitTo(int positon) {
        final View visibleList;
        final View invisibleList;
        selectTitle.setText(titles[positon]);
        selectContent.setText(contents[positon]);
            invisibleList = contenetPage;
            visibleList = titleListPage;
        ObjectAnimator visToInvis = ObjectAnimator.ofFloat(visibleList, "rotationY", 0f, 90f);
        visToInvis.setDuration(500);
        visToInvis.setInterpolator(accelerator);
        final ObjectAnimator invisToVis = ObjectAnimator.ofFloat(invisibleList, "rotationY",
                -90f, 0f);
        invisToVis.setDuration(500);
        invisToVis.setInterpolator(decelerator);
        visToInvis.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator anim) {
                visibleList.setVisibility(View.GONE);
                invisToVis.start();
                invisibleList.setVisibility(View.VISIBLE);
            }
        });
        visToInvis.start();
    }
    
    private void flipitBack() {
        final View visibleList;
        final View invisibleList;
            invisibleList = titleListPage;
            visibleList = contenetPage;
        ObjectAnimator visToInvis = ObjectAnimator.ofFloat(visibleList, "rotationY", 0f, 90f);
        visToInvis.setDuration(500);
        visToInvis.setInterpolator(accelerator);
        final ObjectAnimator invisToVis = ObjectAnimator.ofFloat(invisibleList, "rotationY",
                -90f, 0f);
        invisToVis.setDuration(500);
        invisToVis.setInterpolator(decelerator);
        visToInvis.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator anim) {
                visibleList.setVisibility(View.GONE);
                invisToVis.start();
                invisibleList.setVisibility(View.VISIBLE);
            }
        });
        visToInvis.start();
    }
}