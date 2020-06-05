package jp.techacademy.takanari.soundpooltest

import android.media.AudioTrack
import android.os.Bundle
import android.os.Handler
import android.util.Log
//import android.support.v7.app.AppCompatActivity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(){



    // 譜面データ
    private val soundList0 = ArrayList<SoundDto>()//休符
    private val soundList1 = ArrayList<SoundDto>()//ド
    private val soundList2 = ArrayList<SoundDto>()//レ
    private val soundList3 = ArrayList<SoundDto>()//ミ
    private val soundList4 = ArrayList<SoundDto>()//ファ
    private val soundList5 = ArrayList<SoundDto>()//ソ
    private val soundList6 = ArrayList<SoundDto>()//ラ
    private val soundList7 = ArrayList<SoundDto>()//シ
    private val soundList8 = ArrayList<SoundDto>()//ド(高)

    private val soundListTest = ArrayList<SoundDto>()





    private var soundtest: Boolean = false

    //タイマーが動いてる時に時間数える変数
    private var mTimer: Timer? = null
    //不明　ハンドラーを入れてる？
    private var mHandler = Handler()

//    private var flag:Boolean=false

    enum class SelectMelody {
        C, D, E,F,G,A,B,X,Y,Z,P,N
    }

    var v = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        for (i in 0 until 40) {
            soundList1.add(
                SoundDto(
                    Sound.SOUND_D
                )
            )
            soundList2.add(
                SoundDto(
                    Sound.SOUND_Re
                )
            )
            soundList3.add(
                SoundDto(
                    Sound.SOUND_M
                )
            )
            soundList4.add(
                SoundDto(
                    Sound.SOUND_F
                )
            )
            soundList5.add(
                SoundDto(
                    Sound.SOUND_So
                )
            )
            soundList6.add(
                SoundDto(
                    Sound.SOUND_Ra
                )
            )
            soundList7.add(
                SoundDto(
                    Sound.SOUND_Si
                )
            )
            soundList8.add(
                SoundDto(
                    Sound.SOUND_D2
                )
            )
        }
        // SoundGeneratorクラスをサンプルレート44100で作成

        startbutton.setOnClickListener(mOnstartClickListener)
        Sound.getInstance(this)


//        setVolumeControlStream(AudioManager.STREAM_MUSIC)
        recyclerView1.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) // 1
        recyclerView1.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL)) // 2
        recyclerView1.adapter = MainActivityAdapter(soundList1) { position ->
            //音を鳴らすコード書くとよい

            if (soundList1[position].addflag == false) {
                Sound.getInstance(this).playSound(Sound.SOUND_D)
//                soundList1[position].addflag = true
            }
            else if (soundList1[position].addflag == true){
//                soundList1[position].addflag = false
            }
        }
        recyclerView2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) // 1
        recyclerView2.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL)) // 2
        recyclerView2.adapter = MainActivityAdapter(soundList2) { position ->
            //音を鳴らすコード書くとよい

            if (soundList2[position].addflag == false) {
                Sound.getInstance(this).playSound(Sound.SOUND_Re)
//                soundList2[position].addflag = true
            }
            else if (soundList2[position].addflag == true){
//                soundList2[position].addflag = false
            }
        }
        recyclerView3.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) // 1
        recyclerView3.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL)) // 2
        recyclerView3.adapter = MainActivityAdapter(soundList3) { position ->
            //音を鳴らすコード書くとよい


            if (soundList3[position].addflag == false) {
                Sound.getInstance(this).playSound(Sound.SOUND_M)
//                soundList3[position].addflag = true
            }
            else if (soundList3[position].addflag == true){
//                soundList3[position].addflag = false
            }
        }
        recyclerView4.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) // 1
        recyclerView4.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL)) // 2
        recyclerView4.adapter = MainActivityAdapter(soundList4) { position ->
            //音を鳴らすコード書くとよい

            if (soundList4[position].addflag == false) {
                Sound.getInstance(this).playSound(Sound.SOUND_F)
//                soundList4[position].addflag = true
            }
            else if (soundList4[position].addflag == true){
//                soundList4[position].addflag = false
            }
        }
        recyclerView5.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) // 1
        recyclerView5.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL)) // 2
        recyclerView5.adapter = MainActivityAdapter(soundList5) { position ->
            //音を鳴らすコード書くとよい

            if (soundList5[position].addflag == false) {
                Sound.getInstance(this).playSound(Sound.SOUND_So)
//                soundList5[position].addflag = true
            }
            else if (soundList5[position].addflag == true){
//                soundList5[position].addflag = false
            }
        }
        recyclerView6.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) // 1
        recyclerView6.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL)) // 2
        recyclerView6.adapter = MainActivityAdapter(soundList6) { position ->
            //音を鳴らすコード書くとよい

            if (soundList6[position].addflag == false) {
                Sound.getInstance(this).playSound(Sound.SOUND_Ra)
//                soundList6[position].addflag = true
            }
            else if (soundList6[position].addflag == true){
//                soundList6[position].addflag = false
            }
        }
        recyclerView7.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) // 1
        recyclerView7.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL)) // 2
        recyclerView7.adapter = MainActivityAdapter(soundList7) { position ->
            //音を鳴らすコード書くとよい


            if (soundList7[position].addflag == false) {
                Sound.getInstance(this).playSound(Sound.SOUND_Si)
//                soundList7[position].addflag = true
            }
            else if (soundList7[position].addflag == true){
//                soundList7[position].addflag = false
            }
        }
        recyclerView8.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) // 1
        recyclerView8.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL)) // 2
        recyclerView8.adapter = MainActivityAdapter(soundList8) { position ->

            if (soundList8[position].addflag == false) {
                Sound.getInstance(this).playSound(Sound.SOUND_D2)
//                soundList8[position].addflag = true
            }
            else if (soundList8[position].addflag == true){
//                soundList8[position].addflag = false
            }

        }
    }


    private val mOnstartClickListener = View.OnClickListener {

            for (i in 0 until soundList1.size ) {
                if (soundList1[i].addflag == true) {
                Sound.getInstance(this).playSound(Sound.SOUND_D)
            }
                else {
                    Handler().postDelayed({

                        Log.d("kotlintest","")

                    }, 500)
                }
                if (soundList2[i].addflag == true) {
                    Sound.getInstance(this).playSound(Sound.SOUND_Re)
                }
                else {
                    Handler().postDelayed({

                        Log.d("kotlintest","")

                    }, 500)
                }
                if (soundList3[i].addflag == true) {
                    Sound.getInstance(this).playSound(Sound.SOUND_M)
                }
                else {
                    Handler().postDelayed({

                        Log.d("kotlintest","")

                    }, 500)
                }
                if (soundList4[i].addflag == true) {
                    Sound.getInstance(this).playSound(Sound.SOUND_F)
                }
                else {
                    Handler().postDelayed({

                        Log.d("kotlintest","")

                    }, 500)
                }
                if (soundList5[i].addflag == true) {
                    Sound.getInstance(this).playSound(Sound.SOUND_So)
                }
                else {
                    Handler().postDelayed({

                        Log.d("kotlintest","")

                    }, 500)
                }
                if (soundList6[i].addflag == true) {
                    Sound.getInstance(this).playSound(Sound.SOUND_Ra)
                }
                else {
                    Handler().postDelayed({

                        Log.d("kotlintest","")

                    }, 500)
                }
                if (soundList7[i].addflag == true) {
                    Sound.getInstance(this).playSound(Sound.SOUND_Si)
                }
                else {
                    Handler().postDelayed({

                        Log.d("kotlintest","")

                    }, 500)
                }
                if (soundList8[i].addflag == true) {
                    Sound.getInstance(this).playSound(Sound.SOUND_D2)
                }
                else {
                    Handler().postDelayed({

                        Log.d("kotlintest","")

                    }, 500)
                }

        }
    }

}
