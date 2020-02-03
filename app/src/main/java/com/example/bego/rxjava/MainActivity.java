package com.example.bego.rxjava;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.sql.Time;
import java.util.Observable;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        //cold Observable

//intervalRange  بتبعت دتا بمدة معينة بتبدا من صفر لحد خمسه من غير delay  وتكرار واحد يعنى كل ث لحد خمسه


        io.reactivex.Observable<Long> cold = io.reactivex.Observable.intervalRange(0,5,0,1, TimeUnit.SECONDS);
         cold.subscribe(i-> Log.d(TAG,"onCreate: student 1: "+i));

         try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cold.subscribe(i-> Log.d(TAG,"onCreate: student 2: "+i));
*/
/*
        //hot  Observable from cold (connectable)

        //intervalRange  بتبعت دتا بمدة معينة بتبدا من صفر لحد خمسه من غير delay  وتكرار واحد يعنى كل ث لحد خمسه

        ConnectableObservable<Long> cold = ConnectableObservable.intervalRange(0,5,0,1, TimeUnit.SECONDS).publish();
        cold.connect();
        cold.subscribe(i-> Log.d(TAG,"onCreate: student 1: "+i));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cold.subscribe(i-> Log.d(TAG,"onCreate: student 2: "+i));

*/

        //hot  Observable (publish subject , BehaviorSubject)

       // PublishSubject<String> subject = PublishSubject.create();
        //BehaviorSubject<String> subject = BehaviorSubject.create();
       // ReplaySubject<String> subject = ReplaySubject.create();
       // AsyncSubject<String> subject = AsyncSubject.create();
/*
        subject.subscribe(i-> Log.d(TAG,"onCreate: student 1: "+i));
        subject.onNext("A"); // on next    يعنى انا الل بدخل داتا مش بديها رينج زى اول نوع
        sleep(1000);
        subject.onNext("B"); // on next    يعنى انا الل بدخل داتا مش بديها رينج زى اول نوع
        sleep(1000);
        subject.onNext("C"); // on next    يعنى انا الل بدخل داتا مش بديها رينج زى اول نوع
        sleep(1000);
        subject.subscribe(i-> Log.d(TAG,"onCreate: student 2: "+i));
        subject.onNext("D"); // on next    يعنى انا الل بدخل داتا مش بديها رينج زى اول نوع
        sleep(1000);
        subject.onNext("E"); // on next    يعنى انا الل بدخل داتا مش بديها رينج زى اول نوع
        sleep(1000);
        subject.onNext("F"); // on next    يعنى انا الل بدخل داتا مش بديها رينج زى اول نوع
        sleep(1000);
        subject.onComplete();*/

///**************  Observer & Creation operators ****************//////



        // operators like intervalRange , crreat




        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

                 Log.d(TAG,"onSubscribe: "+d);
            }

            @Override
            public void onNext(Object o) {

                Log.d(TAG,"onNext: "+o);

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"onError: "+e);

            }

            @Override
            public void onComplete() {
                Log.d(TAG,"onComplete: ");

            }
        };

/*
        io.reactivex.Observable observable = io.reactivex.Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {

                // emitter responsable for to pass value to on next method
                for (int i = 0; i < 5; i++) {
                    emitter.onNext(i);
                }
                // invoke on complete method
                emitter.onComplete();
            }
        });
*/

/*
// just is another kind of operator max size is 10 item
        io.reactivex.Observable observable = io.reactivex.Observable.just(0,1,2,3,4);
*/


        Integer [] list = new Integer[5];
        list[0] = 0 ;
        list[1] = 1 ;
        list[2] = 2 ;
        list[3] = 3 ;
        list[4] = 4 ;
// fromArray is another kind of operator
        io.reactivex.Observable observable = io.reactivex.Observable.fromArray(list);
         // if you want to repeat array user .repeat     fromArray(list).repeat

        // Link  observable with  observer
        observable.subscribe(observer);

    }

    public  void sleep(int i )
    {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
