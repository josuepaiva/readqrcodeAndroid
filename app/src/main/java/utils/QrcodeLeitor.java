package utils;

import android.app.Activity;
import android.content.Context;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.qrcode.encoder.QRCode;

import static utils.Camera.CAMERA_FRONTAL;

public class QrcodeLeitor {
    private QRCode qrCode;
    private Context ctx;

    public QrcodeLeitor(Context ctx) {
        this.qrCode = new QRCode();
        this.ctx = ctx;
    }

    public QRCode getQrCode() {
        return qrCode;
    }

    public void setQrCode(QRCode qrCode) {
        this.qrCode = qrCode;
    }

    public void lerqrcode(Activity activity){
        IntentIntegrator intentIntegrator = new IntentIntegrator(activity);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        intentIntegrator.setPrompt("Camera Scan");
        intentIntegrator.setCameraId(CAMERA_FRONTAL.getValor());
        intentIntegrator.initiateScan();

    }

    public String teste() {
        return "Sucesso";
    }
}
