package lin.abcdq.camera

import android.opengl.GLSurfaceView
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class CameraJni : GLSurfaceView.Renderer {

    companion object {
        const val FORMAT_RGBA = 0x01
        const val FORMAT_YUV420888 = 0x02
        const val FORMAT_YUV420 = 0x03
        const val FORMAT_YUV421 = 0x04
        const val FORMAT_YUV422 = 0x05
        const val FORMAT_NV21 = 0x06
    }

    init {
        System.loadLibrary("CAMERA_LIB")
    }

    fun onInit(type: Int) {
        native_OnInit(type)
    }

    fun onPreview(dataBytes: ByteArray, w: Int, h: Int) {
        native_OnPreview(dataBytes, w, h)
    }

    fun onCapture(): ByteArray? {
        try {
            return native_OnCapture()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        native_OnSurfaceCreated()
    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        native_OnSurfaceChanged(width, height)
    }

    override fun onDrawFrame(gl: GL10?) {
        native_OnDrawFrame()
    }

    fun onDestroy() {
        native_OnDestroy()
    }

    private external fun native_OnInit(type: Int)

    private external fun native_OnSurfaceCreated()

    private external fun native_OnSurfaceChanged(w: Int, h: Int)

    private external fun native_OnDrawFrame()

    private external fun native_OnPreview(dataBytes: ByteArray, w: Int, h: Int)

    private external fun native_OnCapture(): ByteArray?

    private external fun native_OnDestroy()
}