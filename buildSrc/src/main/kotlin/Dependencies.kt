/**
 *
 *
 *
 */
object Dependencies {

    val lifeCycle = LifeCycle
    object LifeCycle{
        val lifecycle_version = "2.5.1"

        var ViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
        var LiveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
        var SaveStateViewModel = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version"
    }

    val paging = Paging
    object Paging{
        val paging_version = "3.1.1"

        val paging = "androidx.paging:paging-runtime:$paging_version"
    }

    private const val exoPlayerVersion = "2.18.0"
    const val EXO_PLAYER = "com.google.android.exoplayer:exoplayer:$exoPlayerVersion"

    val retrofit = Retrofit
    object Retrofit{
        private const val VERSION = "2.9.0"

        const val retrofit2 = "com.squareup.retrofit2:retrofit:$VERSION"
        const val gsonConvert = "com.squareup.retrofit2:converter-gson:$VERSION"
    }

    private const val gsonVersion = "2.10"
    const val gson = "com.google.code.gson:gson:2.10"

}