package com.chinacnd.framework.util;

import java.io.*;
import java.io.InputStreamReader;

public class FileUtils {

    public static void copy(String sourceFilePath, String targetFilePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(sourceFilePath);
            copy(fileInputStream, targetFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copy(File inputFile, String targetFilePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            copy(fileInputStream, targetFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copy(InputStream inputStream, String targetChildFilePath) {
        try {
            BufferedInputStream input = new BufferedInputStream(inputStream);
            File outputFile = new File(targetChildFilePath);
            if (outputFile.exists()) {
                outputFile.delete();
            }
            File parentFile = outputFile.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outputFile));
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = input.read(b)) != -1) {
                output.write(b, 0, len);
            }
            output.flush();
            output.close();
            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把一个文本输入流存成一个用UTF8编码保存的文本文件
     * @param inputStream 输入的文本流
     * @param inputEncode 输入的编码
     * @param targetChildFilePath 保存的文件路径及文件名
     */
    public static void copyTextFileToUTF8(InputStream inputStream, String inputEncode, String targetChildFilePath, TextFileContentProccessor proccessor) {
        copyTextFile(inputStream, inputEncode, targetChildFilePath, "UTF8", proccessor);
    }

    /**
     * 把一个文本输入流存成一个用指定编码保存的文本文件
     * @param inputStream 输入的文本流
     * @param inputEncode 输入的编码
     * @param targetChildFilePath 保存的文件路径及文件名
     * @param outputEncode 输出的文件编码
     */
    public static void copyTextFile(InputStream inputStream, String inputEncode, String targetChildFilePath, String outputEncode, TextFileContentProccessor proccessor) {
        OutputStreamWriter writer = null;
        BufferedReader input = null;
        try {
            InputStreamReader reader = new InputStreamReader(inputStream, inputEncode);
            input = new BufferedReader(reader);
            File outputFile = new File(targetChildFilePath);
            if (outputFile.exists()) {
                outputFile.delete();
            }
            File parentFile = outputFile.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            writer = new OutputStreamWriter(new FileOutputStream(outputFile), outputEncode);
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = input.readLine()) != null) {
                sb.append(line).append("\r\n");
            }
            writer.write(proccessor.proccess(sb.toString()));
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                writer.close();
                input.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String getFileType(File file) {
        String fileName = file.getName();
        return getFileType(fileName);
    }

    public static String getFileType(String fileName) {
        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex > -1) {
            return fileName.substring(lastDotIndex + 1).toLowerCase();
        }
        return "";
    }

    public static void close(InputStream stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                //ignore
            }
        }
    }

    public static void deleteFile(String file) {
        new File(file).delete();
    }

    public static String readFileStream(String file, String encode) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), encode));
        try {
            String temp = null;
            while ((temp = br.readLine()) != null) {
                sb.append(temp).append("\n");
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return sb.toString();
    }

    public static void write(String content, File file, String encoding) {
        try {
            file.getParentFile().mkdirs();
            OutputStreamWriter fileWriter = new OutputStreamWriter(new FileOutputStream(file), encoding);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyTEXTFileAndProccessStrings(boolean overwrite, InputStream inputStream, String inputEncode, String targetName, String outputEncode, TextFileContentProccessor proccessor) {
        try {
            InputStreamReader reader = new InputStreamReader(inputStream, inputEncode);
            BufferedReader input = new BufferedReader(reader);
            File outputFile = new File(targetName);
            if (outputFile.exists()) {
                if(overwrite){
                    outputFile.delete();
                }else{
                    return;
                }
            }
            File parentFile = outputFile.getParentFile();
            if (parentFile!=null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(outputFile), outputEncode);
            BufferedWriter output = new BufferedWriter(writer);
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = input.readLine()) != null) {
                sb.append(line).append("\r\n");
            }
            String content = sb.toString();
            output.write(proccessor.proccess(content));
            output.flush();
            output.close();
            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getEncodeName(String unpackEncode, String targetName) {
        return targetName+"_"+unpackEncode;
    }
}
