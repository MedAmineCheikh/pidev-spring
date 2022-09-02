package tn.esprit.spring.utils;

public class FileUploadResponse {
private String fileName;
private String DownloadUri;
private long size;
/**
 * @return the fileName
 */
public String getFileName() {
	return fileName;
}
/**
 * @param fileName the fileName to set
 */
public void setFileName(String fileName) {
	this.fileName = fileName;
}
/**
 * @return the downloadUri
 */
public String getDownloadUri() {
	return DownloadUri;
}
/**
 * @param downloadUri the downloadUri to set
 */
public void setDownloadUri(String downloadUri) {
	DownloadUri = downloadUri;
}
/**
 * @return the size
 */
public long getSize() {
	return size;
}
/**
 * @param size the size to set
 */
public void setSize(long size) {
	this.size = size;
}
}
