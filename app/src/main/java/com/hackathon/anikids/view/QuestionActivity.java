package com.hackathon.anikids.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hackathon.anikids.R;
import com.hackathon.anikids.control.DinhTranTextView;
import com.hackathon.anikids.database.DatabaseManager;
import com.hackathon.anikids.model.Question;
import com.hackathon.anikids.widget.SwipeBackActivity;
import com.hackathon.anikids.widget.SwipeBackLayout;

public class QuestionActivity extends SwipeBackActivity implements View.OnClickListener{
    TextView tvQuestion;
    DinhTranTextView tvAns1;
    DinhTranTextView tvAns2;
    DinhTranTextView tvAns3;
    DinhTranTextView tvAns4;
    Question question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        tvAns1 = (DinhTranTextView) findViewById(R.id.tvQuestion1);
        tvAns2 = (DinhTranTextView) findViewById(R.id.tvQuestion2);
        tvAns3 = (DinhTranTextView) findViewById(R.id.tvQuestion3);
        tvAns4 = (DinhTranTextView) findViewById(R.id.tvQuestion4);
        makeQuestion();
        tvAns1.setOnClickListener(this);
        tvAns2.setOnClickListener(this);
        tvAns3.setOnClickListener(this);
        tvAns4.setOnClickListener(this);

        setDragEdge(SwipeBackLayout.DragEdge.RIGHT);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvQuestion1:
                if(question.getAnswers1().isTrue()){
                    Toast toast = new Toast(QuestionActivity.this);
                    View viewToast = LayoutInflater.from(this).inflate(R.layout.toast_corret_layout, null);
                    ((TextView) viewToast.findViewById(R.id.tv_text)).setText("Bạn đã chọn đúng");

                    toast.setView(viewToast);
                    toast.show();


                    makeQuestion();
                    MediaPlayer.create(this, R.raw.correct).start();
                }else {
//                    Toast.makeText(this, "Xin chúc mừng bạn đã chọn sai", Toast.LENGTH_SHORT).show();
                    Toast toast = new Toast(QuestionActivity.this);
                    View viewToast = LayoutInflater.from(this).inflate(R.layout.toast_incorret_layout, null);
                    ((TextView) viewToast.findViewById(R.id.tv_text)).setText("Bạn đã chọn sai, vui lòng chọn lại");

                    toast.setView(viewToast);
                    toast.show();
                    MediaPlayer.create(this, R.raw.wrong).start();
                }
                break;
            case R.id.tvQuestion2:
                if(question.getAnswers2().isTrue()){
                    Toast toast = new Toast(QuestionActivity.this);
                    View viewToast = LayoutInflater.from(this).inflate(R.layout.toast_corret_layout, null);
                    ((TextView) viewToast.findViewById(R.id.tv_text)).setText("Bạn đã chọn đúng");

                    toast.setView(viewToast);
                    toast.show();
                    makeQuestion();
                    MediaPlayer.create(this, R.raw.correct).start();
                }else {
//                    Toast.makeText(this, "Xin chúc mừng bạn đã chọn sai", Toast.LENGTH_SHORT).show();
                    Toast toast = new Toast(QuestionActivity.this);
                    View viewToast = LayoutInflater.from(this).inflate(R.layout.toast_incorret_layout, null);
                    ((TextView) viewToast.findViewById(R.id.tv_text)).setText("Bạn đã chọn sai, vui lòng chọn lại");

                    toast.setView(viewToast);
                    toast.show();
                    MediaPlayer.create(this, R.raw.wrong).start();
                }
                break;
            case R.id.tvQuestion3:
                if(question.getAnswers3().isTrue()){
                    Toast toast = new Toast(QuestionActivity.this);
                    View viewToast = LayoutInflater.from(this).inflate(R.layout.toast_corret_layout, null);
                    ((TextView) viewToast.findViewById(R.id.tv_text)).setText("Bạn đã chọn đúng");

                    toast.setView(viewToast);
                    toast.show();
                    makeQuestion();
                    MediaPlayer.create(this, R.raw.correct).start();
                }else {
                    Toast toast = new Toast(QuestionActivity.this);
                    View viewToast = LayoutInflater.from(this).inflate(R.layout.toast_incorret_layout, null);
                    ((TextView) viewToast.findViewById(R.id.tv_text)).setText("Bạn đã chọn sai, vui lòng chọn lại");

                    toast.setView(viewToast);
                    toast.show();
                    MediaPlayer.create(this, R.raw.wrong).start();
                }
                break;
            case R.id.tvQuestion4:
                if(question.getAnswers4().isTrue()){
                    Toast toast = new Toast(QuestionActivity.this);
                    View viewToast = LayoutInflater.from(this).inflate(R.layout.toast_corret_layout, null);
                    ((TextView) viewToast.findViewById(R.id.tv_text)).setText("Bạn đã chọn đúng");

                    toast.setView(viewToast);
                    toast.show();;
                    makeQuestion();
                    MediaPlayer.create(this, R.raw.correct).start();
                }else {
//                    Toast.makeText(this, "Xin chúc mừng bạn đã chọn sai", Toast.LENGTH_SHORT).show();
                    Toast toast = new Toast(QuestionActivity.this);
                    View viewToast = LayoutInflater.from(this).inflate(R.layout.toast_incorret_layout, null);
                    ((TextView) viewToast.findViewById(R.id.tv_text)).setText("Bạn đã chọn sai, vui lòng chọn lại");

                    toast.setView(viewToast);
                    toast.show();
                    MediaPlayer.create(this, R.raw.wrong).start();
                }
                break;
        }
    }
    private void makeQuestion(){
        setAnimation(tvAns1);
        setAnimation(tvAns2);
        setAnimation(tvAns3);
        setAnimation(tvAns4);
        setAnimation(tvQuestion);
        question = DatabaseManager.getInstance(this).getRandomQuestion();
        tvQuestion.setText(question.getQuestion());
        tvAns1.setText(question.getAnswers1().getAnswer());
        tvAns2.setText(question.getAnswers2().getAnswer());
        tvAns3.setText(question.getAnswers3().getAnswer());
        tvAns4.setText(question.getAnswers4().getAnswer());
    }
    private void setAnimation(View view){

       /* Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(1000);

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setStartOffset(1000);
        fadeOut.setDuration(1000);

        AnimationSet animation = new AnimationSet(true);
        animation.addAnimation(fadeIn);
        animation.addAnimation(fadeOut);
        view.setAnimation(animation);*/
        ObjectAnimator faceOut = ObjectAnimator.ofFloat(view,View.ALPHA, 1, 0);
        faceOut.setDuration(1000);
        faceOut.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        faceOut.start();

        ObjectAnimator faceIn = ObjectAnimator.ofFloat(view,View.ALPHA, 0, 1);
        faceIn.setDuration(1000);
        faceIn.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        faceIn.start();

    }
}
