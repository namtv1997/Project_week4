package namhenry.com.vn.projectweek4

import android.app.Application

class MyApplication : Application() {

    companion object {
        private lateinit var mSelf: MyApplication

        fun self(): MyApplication {
            return mSelf
        }
    }


    override fun onCreate() {
        super.onCreate()
        mSelf = this
    }
}