package com.oracle.data;

import java.util.Random;

public class LocationAndEmployees {

	private static String[] locAndEmp = {
	
		"  \"location\": {                                        \n"+
		"     \"city\": \"New York\",                             \n"+
		"     \"state\": \"NY\",                                  \n"+
		"     \"address\": \"501 7th Avenue\",                    \n"+
		"     \"zipcode\": \"10018\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Sarah\",                           \n"+
		"     \"lastName\": \"Connor\"                            \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"New York\",                             \n"+
		"     \"state\": \"NY\",                                  \n"+
		"     \"address\": \"501 7th Avenue\",                    \n"+
		"     \"zipcode\": \"10018\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Hermann\",                         \n"+
		"     \"lastName\": \"Cuttlery\"                          \n"+
		"  }",
		
		"  \"location\": {                                        \n"+
		"     \"city\": \"New York\",                             \n"+
		"     \"state\": \"NY\",                                  \n"+
		"     \"address\": \"501 7th Avenue\",                    \n"+
		"     \"zipcode\": \"10018\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Marco\",                           \n"+
		"     \"lastName\": \"Franco\"                            \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"New York\",                             \n"+
		"     \"state\": \"NY\",                                  \n"+
		"     \"address\": \"501 7th Avenue\",                    \n"+
		"     \"zipcode\": \"10018\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Sarah\",                           \n"+
		"     \"lastName\": \"Connor\"                            \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"New York\",                             \n"+
		"     \"state\": \"NY\",                                  \n"+
		"     \"address\": \"501 7th Avenue\",                    \n"+
		"     \"zipcode\": \"10018\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Hermann\",                         \n"+
		"     \"lastName\": \"Cuttlery\"                          \n"+
		"  }",
		
		"  \"location\": {                                        \n"+
		"     \"city\": \"New York\",                             \n"+
		"     \"state\": \"NY\",                                  \n"+
		"     \"address\": \"501 7th Avenue\",                    \n"+
		"     \"zipcode\": \"10018\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Marco\",                           \n"+
		"     \"lastName\": \"Franco\"                            \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"New York\",                             \n"+
		"     \"state\": \"NY\",                                  \n"+
		"     \"address\": \"501 7th Avenue\",                    \n"+
		"     \"zipcode\": \"10018\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Sarah\",                           \n"+
		"     \"lastName\": \"Connor\"                            \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"New York\",                             \n"+
		"     \"state\": \"NY\",                                  \n"+
		"     \"address\": \"501 7th Avenue\",                    \n"+
		"     \"zipcode\": \"10018\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Hermann\",                         \n"+
		"     \"lastName\": \"Cuttlery\"                          \n"+
		"  }",
		
		"  \"location\": {                                        \n"+
		"     \"city\": \"New York\",                             \n"+
		"     \"state\": \"NY\",                                  \n"+
		"     \"address\": \"501 7th Avenue\",                    \n"+
		"     \"zipcode\": \"10018\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Marco\",                           \n"+
		"     \"lastName\": \"Franco\"                            \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Boston\",                               \n"+
		"     \"state\": \"MA\",                                  \n"+
		"     \"address\": \"74 Essex Street\",                   \n"+
		"     \"zipcode\": \"02111\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Sebastian\",                       \n"+
		"     \"lastName\": \"Ellis\"                             \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Boston\",                               \n"+
		"     \"state\": \"MA\",                                  \n"+
		"     \"address\": \"74 Essex Street\",                   \n"+
		"     \"zipcode\": \"02111\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"George\",                          \n"+
		"     \"lastName\": \"Federick\"                          \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Boston\",                               \n"+
		"     \"state\": \"MA\",                                  \n"+
		"     \"address\": \"74 Essex Street\",                   \n"+
		"     \"zipcode\": \"02111\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Allan\",                           \n"+
		"     \"lastName\": \"Secoya\"                            \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Washington\",                           \n"+
		"     \"state\": \"DC\",                                  \n"+
		"     \"address\": \"408 Q Street North West\",           \n"+
		"     \"zipcode\": \"20001\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"William\",                         \n"+
		"     \"lastName\": \"Sorrento\"                          \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Washington\",                           \n"+
		"     \"state\": \"DC\",                                  \n"+
		"     \"address\": \"408 Q Street North West\",           \n"+
		"     \"zipcode\": \"20001\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Alac\",                            \n"+
		"     \"lastName\": \"McClaflin\"                         \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Washington\",                           \n"+
		"     \"state\": \"DC\",                                  \n"+
		"     \"address\": \"408 Q Street North West\",           \n"+
		"     \"zipcode\": \"20001\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Eric\",                            \n"+
		"     \"lastName\": \"Baldron\"                           \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"San Francisco\",                        \n"+
		"     \"state\": \"CA\",                                  \n"+
		"     \"address\": \"100 Van Ness Avenue\",               \n"+
		"     \"zipcode\": \"94102\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Gerald\",                          \n"+
		"     \"lastName\": \"Baer\"                              \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"San Francisco\",                        \n"+
		"     \"state\": \"CA\",                                  \n"+
		"     \"address\": \"100 Van Ness Avenue\",               \n"+
		"     \"zipcode\": \"94102\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Maria\",                           \n"+
		"     \"lastName\": \"Venzl\"                             \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"San Francisco\",                        \n"+
		"     \"state\": \"CA\",                                  \n"+
		"     \"address\": \"100 Van Ness Avenue\",               \n"+
		"     \"zipcode\": \"94102\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Allison\",                         \n"+
		"     \"lastName\": \"Swartz\"                            \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"San Francisco\",                        \n"+
		"     \"state\": \"CA\",                                  \n"+
		"     \"address\": \"100 Van Ness Avenue\",               \n"+
		"     \"zipcode\": \"94102\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Gerald\",                          \n"+
		"     \"lastName\": \"Baer\"                              \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"San Francisco\",                        \n"+
		"     \"state\": \"CA\",                                  \n"+
		"     \"address\": \"100 Van Ness Avenue\",               \n"+
		"     \"zipcode\": \"94102\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Maria\",                           \n"+
		"     \"lastName\": \"Venzl\"                             \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Los Angeles\",                          \n"+
		"     \"state\": \"CA\",                                  \n"+
		"     \"address\": \"3226 Oakhurst Avenue\",              \n"+
		"     \"zipcode\": \"90034\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Stacey\",                          \n"+
		"     \"lastName\": \"Boldon\"                            \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Los Angeles\",                          \n"+
		"     \"state\": \"CA\",                                  \n"+
		"     \"address\": \"3226 Oakhurst Avenue\",              \n"+
		"     \"zipcode\": \"90034\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Stacey\",                          \n"+
		"     \"lastName\": \"Boldon\"                            \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Los Angeles\",                          \n"+
		"     \"state\": \"CA\",                                  \n"+
		"     \"address\": \"3226 Oakhurst Avenue\",              \n"+
		"     \"zipcode\": \"90034\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Lucy\",                            \n"+
		"     \"lastName\": \"Granger\"                           \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Los Angeles\",                          \n"+
		"     \"state\": \"CA\",                                  \n"+
		"     \"address\": \"3226 Oakhurst Avenue\",              \n"+
		"     \"zipcode\": \"90034\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Angelina\",                        \n"+
		"     \"lastName\": \"Heinrich\"                          \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Los Angeles\",                          \n"+
		"     \"state\": \"CA\",                                  \n"+
		"     \"address\": \"3226 Oakhurst Avenue\",              \n"+
		"     \"zipcode\": \"90034\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Stacey\",                          \n"+
		"     \"lastName\": \"Boldon\"                            \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Los Angeles\",                          \n"+
		"     \"state\": \"CA\",                                  \n"+
		"     \"address\": \"3226 Oakhurst Avenue\",              \n"+
		"     \"zipcode\": \"90034\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Lucy\",                            \n"+
		"     \"lastName\": \"Granger\"                           \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Los Angeles\",                          \n"+
		"     \"state\": \"CA\",                                  \n"+
		"     \"address\": \"3226 Oakhurst Avenue\",              \n"+
		"     \"zipcode\": \"90034\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Angelina\",                        \n"+
		"     \"lastName\": \"Heinrich\"                          \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Philadelphia\",                         \n"+
		"     \"state\": \"PA\",                                  \n"+
		"     \"address\": \"1106 Chestnut Street\",              \n"+
		"     \"zipcode\": \"19107\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Stuart\",                          \n"+
		"     \"lastName\": \"Ernesto\"                           \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Chicago\",                              \n"+
		"     \"state\": \"IL\",                                  \n"+
		"     \"address\": \"112 E Chestnut Street\",             \n"+
		"     \"zipcode\": \"60611\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Daniel\",                          \n"+
		"     \"lastName\": \"Dienst\"                            \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Chicago\",                              \n"+
		"     \"state\": \"IL\",                                  \n"+
		"     \"address\": \"112 E Chestnut Street\",             \n"+
		"     \"zipcode\": \"60611\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Emma\",                            \n"+
		"     \"lastName\": \"Marcus\"                            \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Chicago\",                              \n"+
		"     \"state\": \"IL\",                                  \n"+
		"     \"address\": \"112 E Chestnut Street\",             \n"+
		"     \"zipcode\": \"60611\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Ronald\",                          \n"+
		"     \"lastName\": \"Radcliff\"                          \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Chicago\",                              \n"+
		"     \"state\": \"IL\",                                  \n"+
		"     \"address\": \"112 E Chestnut Street\",             \n"+
		"     \"zipcode\": \"60611\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Daniel\",                          \n"+
		"     \"lastName\": \"Dienst\"                            \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Chicago\",                              \n"+
		"     \"state\": \"IL\",                                  \n"+
		"     \"address\": \"112 E Chestnut Street\",             \n"+
		"     \"zipcode\": \"60611\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Emma\",                            \n"+
		"     \"lastName\": \"Marcus\"                            \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Chicago\",                              \n"+
		"     \"state\": \"IL\",                                  \n"+
		"     \"address\": \"112 E Chestnut Street\",             \n"+
		"     \"zipcode\": \"60611\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Ronald\",                          \n"+
		"     \"lastName\": \"Radcliff\"                          \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Dallas\",                               \n"+
		"     \"state\": \"TX\",                                  \n"+
		"     \"address\": \"1840 Ross Avenue\",                  \n"+
		"     \"zipcode\": \"75201\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"Lorea\",                           \n"+
		"     \"lastName\": \"Ibiza\"                             \n"+
		"  }",

		"  \"location\": {                                        \n"+
		"     \"city\": \"Dallas\",                               \n"+
		"     \"state\": \"TX\",                                  \n"+
		"     \"address\": \"1840 Ross Avenue\",                  \n"+
		"     \"zipcode\": \"75201\"                              \n"+
		"  },                                                     \n"+
		"  \"employee\": {                                        \n"+
		"     \"firstName\": \"George\",                          \n"+
		"     \"lastName\": \"Raddison\"                          \n"+
		"  }"
	};
	
	public static String getLocAndEmp() {
		Random random = new Random();
		return locAndEmp[random.nextInt(locAndEmp.length)];

	}
}
