package net.minecraft.util.io.netty.handler.codec.http;

public interface HttpRequest extends HttpMessage {
  HttpMethod getMethod();
  
  HttpRequest setMethod(HttpMethod paramHttpMethod);
  
  String getUri();
  
  HttpRequest setUri(String paramString);
  
  HttpRequest setProtocolVersion(HttpVersion paramHttpVersion);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\codec\http\HttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */