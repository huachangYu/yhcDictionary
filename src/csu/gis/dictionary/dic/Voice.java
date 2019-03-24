package csu.gis.dictionary.dic;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.*;

public class Voice {

    protected static String mainPath = "D:\\biancheng\\java\\yhcDictionar_beta2\\voice\\";
    protected static String[] website={"http://dict.youdao.com/dictvoice?type=1&audio=","http://dict.youdao.com/dictvoice?type=2&audio="};

    public static void wordVoicePlay(String name,int type) throws IOException {
        getVoice(name,type);
        play(name,type);
    }

    public static void getVoice(String name,int type) throws MalformedURLException, IOException {
        String subpath = name + "/";
        URL url = new URL(website[type] + subpath);
        try {
            java.io.FileOutputStream fos;
            try (InputStream is = url.openStream()) {
                int flag = 0;
                File file = new File("D:\\biancheng\\java\\yhcDictionar_beta2\\voice\\" + name +String.valueOf(type)+ ".mp3");
                if (!file.exists()) {
                    file.createNewFile();
                }   fos = new FileOutputStream(file);
                while ((flag = is.read()) != -1) {
                    fos.write(flag);
                }
            }
            fos.close();
        } catch (IOException e) {
            
        }
    }

    public static void play(String name,int type) {
        File f = new File(mainPath + name +String.valueOf(type)+ ".mp3");
        try {
            AudioInputStream in = AudioSystem.getAudioInputStream(f);
            AudioFormat fm = getOutFormat(in.getFormat());
            DataLine.Info info = new DataLine.Info(Clip.class, fm);
            Clip c = (Clip) AudioSystem.getLine(info);
            if (c != null) {
                c.open(AudioSystem.getAudioInputStream(fm, in));
                c.start();
                Thread.sleep(2000);
                c.drain();
                c.stop();
            }
        } catch (IOException | InterruptedException | LineUnavailableException | UnsupportedAudioFileException e) {
            throw new IllegalStateException(e);
        }
    }

    private static AudioFormat getOutFormat(AudioFormat inFormat) {
        final int ch = inFormat.getChannels();
        final float rate = inFormat.getSampleRate();
        return new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, rate, 16, ch, ch * 2, rate, false);
    }
}
