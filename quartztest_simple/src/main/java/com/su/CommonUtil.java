package com.su;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author NieSu  2018/10/13
 */
public class CommonUtil
{

  /**
   *
   * @return
   */
  public static String getTime()
  {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return df.format(new Date());

  }
}
