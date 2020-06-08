package jp.techacademy.takanari.soundpooltest

import android.annotation.TargetApi
import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build

class Sound constructor(context: Context) {


    private var soundPool: SoundPool? = null


    companion object {

        var SOUND_D = 0
        var SOUND_Re = 0
        var SOUND_M = 0
        var SOUND_F = 0
        var SOUND_So = 0
        var SOUND_Ra = 0
        var SOUND_Si = 0
        var SOUND_D2 = 0
        var SOUND_N = 0


        var INSTANCE:Sound? = null
        fun getInstance(context: Context) =
            INSTANCE ?: Sound(context).also {
                INSTANCE = it
            }

    }

    init {
        createSoundPool()
        loadSoundIDs(context)
    }

    private fun createSoundPool() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            createNewSoundPool()
        } else {
            createOldSoundPool()
        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun createNewSoundPool() {
        val attributes = AudioAttributes.Builder().apply {
            setUsage(AudioAttributes.USAGE_GAME)
            setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)

        }.build()

        soundPool = SoundPool.Builder().apply {
            setMaxStreams(9)
            setAudioAttributes(attributes)
        }.build()
    }


    private fun createOldSoundPool() {
        soundPool = SoundPool(2, AudioManager.STREAM_MUSIC, 0)
    }

    private fun loadSoundIDs(context:Context) {
        soundPool?.let {
            println("サウンドファイルロード")
            SOUND_D = it.load(context, R.raw.d, 1)
            SOUND_Re = it.load(context, R.raw.re, 1)
            SOUND_M = it.load(context, R.raw.mi, 1)
            SOUND_F = it.load(context, R.raw.fa, 1)
            SOUND_So = it.load(context, R.raw.so, 1)
            SOUND_Ra = it.load(context, R.raw.ra, 1)
            SOUND_Si = it.load(context, R.raw.si, 1)
            SOUND_D2 = it.load(context, R.raw.do2, 1)
            SOUND_N = it.load(context, R.raw.n, 1)

        }
    }


    fun playSound(soundID:Int) {
        soundPool?.let{
            it.play(soundID, 1.0f, 1.0f, 1, 0, 2.0f)
            println("サウンド再生")
        }
    }


    fun close() { // シングルトンの場合呼びようがない？
        soundPool?.release()
        soundPool = null
    }
}