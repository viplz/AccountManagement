package com.exam.model;


public class ResponseMessage {
	
	private int code;
	private Data data;
	private String message;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static ResponseMessage returnUrlMessage(int code, String url, String message) {
		ResponseMessage responseMessage = new ResponseMessage();
		Data data = responseMessage.new Data();
		data.setUrl(url);
		responseMessage.setCode(code);
		responseMessage.setMessage(message);
		responseMessage.setData(data);
		return responseMessage;
	}
	
	public static ResponseMessage returnHtmlMessage(int code, String html, String message) {
		ResponseMessage responseMessage = new ResponseMessage();
		Data data = responseMessage.new Data();
		data.setHtml(html);
		responseMessage.setCode(code);
		responseMessage.setMessage(message);
		responseMessage.setData(data);
		return responseMessage;
	}

	public class Data {
		
		private String html;
		
		private String url;
		
		public String getUrl() {
			return url;
		}

		public void setHtml(String html) {
			this.html = html;
		}
		
		public String getHtml() {
			return html;
		}

		public void setUrl(String url) {
			this.url = url;
		}
		
	}
}
