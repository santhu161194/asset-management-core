package org.medplus.assetmanagementcore;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medplus.assetmanagementcore.exceptions.AssetException;
import org.medplus.assetmanagementcore.exceptions.AuthenticationException;
import org.medplus.assetmanagementcore.exceptions.EmployeeException;
import org.medplus.assetmanagementcore.model.Asset;
import org.medplus.assetmanagementcore.model.NewTypeRequest;
import org.medplus.assetmanagementcore.model.Request;
import org.medplus.assetmanagementcore.service.AssetService;
import org.medplus.assetmanagementcore.utils.AppConfig;
import org.medplus.assetmanagementcore.utils.AssetStatus;
import org.medplus.assetmanagementcore.utils.AssetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


@Ignore
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class AssetTest {
 
 @Autowired
 AssetService assetService;

 @Test
 public void testGetAssetSuccess() {
  Asset asset=new Asset();
  
  boolean isResult=false;
  
   try {
    asset =assetService.getAsset(10);
    isResult=true;
   } catch (AssetException e) {
    System.out.println(e.getMessage());
   } 
  assertEquals(isResult,true);
 }
 
 @Test
 public void testGetAssetFailure() {
  Asset asset=new Asset();
  
  boolean isResult=false;
  
   try {
    asset =assetService.getAsset(1234);
    isResult=true;
   } catch (AssetException e) {
    System.out.println(e.getMessage());
   } 
  assertEquals(isResult,false);
 }
 
 
 @Test
 public void testGetAllAssetsSuccess()
 {
  List<Asset> assetList = null;
  boolean isResult=false;
  
   try {
    assetList = assetService.getAllAssets();
    isResult=true;
       System.out.println(assetList.size());
       for (Asset asset : assetList) {
           System.out.println(asset.getAssetId());
       }
   } catch (AssetException e) {
    System.out.println(e.getMessage());
   }
   assertEquals(isResult,true); 

 }
 
 @Ignore
 @Test
 public void testGetAllAssetsFailure()
 {
  List<Asset> assetList = null;
  boolean isResult=false;
  
   try {
    assetList = assetService.getAllAssets();
    isResult=true;
    System.out.println(assetList.size());
       for (Asset asset : assetList) {
           System.out.println(asset.getAssetId());
       }
   } catch (AssetException e) {
    // TODO Auto-generated catch block
	    System.out.println(e.getMessage());
   }
   assertEquals(isResult,false); 

 }
 @Ignore
@Test
 public void addAssetSuccess()
 {
  String message=null;
  Asset asset=new Asset();
  asset.setAssetName("lappya");
  asset.setSerialNumber("ser122");
  asset.setAssetId(44);
  asset.setAssetType(AssetType.Laptop);
  asset.setStatus(AssetStatus.Available);
  asset.setCost(12344);
  asset.setCreatedBy("5555555");
  asset.setCreatedDate(new Date());
  String expectedResult = "Asset Added Successfully..";
 
   
    try {
		message = assetService.addAsset(asset);
	} catch (AssetException e) {
		// TODO Auto-generated catch block
	    System.out.println(e.getMessage());
	} catch (AuthenticationException e) {
		// TODO Auto-generated catch block
	    System.out.println(e.getMessage());
	} catch (EmployeeException e) {
		// TODO Auto-generated catch block
	    System.out.println(e.getMessage());
	}
    

   
 
assertEquals(expectedResult,message);
 }
 
@Ignore
@Test
public void addAssetFailure()
{
 String message=null;
 Asset asset=new Asset();
 asset.setAssetName("lappy");
 asset.setAssetId(44);
 asset.setSerialNumber("1234");
 asset.setAssetType(AssetType.Laptop);
 asset.setStatus(AssetStatus.Available);
 asset.setCost(12344);
 asset.setCreatedBy("5555555");
 asset.setCreatedDate(new Date());
 boolean isResult=false;

   try {
	message = assetService.addAsset(asset);
} catch (AssetException e) {
	
    System.out.println(e.getMessage());
} catch (AuthenticationException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
} catch (EmployeeException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
}
   isResult=true;

assertEquals(isResult,false);
}
@Ignore
@Test
public void updateAssetStatusSuccess()
{
 String message=null;
 String expectedResult = "success";
 
   try {
	message = assetService.updateAssetStatus(10, AssetStatus.Available, "12345678");
} catch (AuthenticationException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
} catch (AssetException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
} catch (EmployeeException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
}
 
 assertEquals(expectedResult,message);
}

@Test
public void testGetAssetsByStatusSuccess()
{
 List assetByStatus = null;
 boolean isResult=false;
 
  try {
   assetByStatus =assetService.getAssetsByStatus("A");
   isResult=true;
  } catch (AssetException e) {
   System.out.println(e.getMessage());
  }
 
  assertEquals(isResult,true); 

}
@Ignore
@Test
public void testGetAssetsByStatusFailure()
{
 List assetByStatus = null;
 boolean isResult=false;
 
  try {
   assetByStatus =assetService.getAssetsByStatus("Avv");
   isResult=true;
  } catch (AssetException e) {
   System.out.println(e.getMessage());
  }
 
  assertEquals(isResult,false); 

}

@Test
public void testGetAssetsOfEmployeeSuccess()
{
 List assetOfEmployee = null;
 boolean isResult=false;
 
  
   try {
    assetOfEmployee =assetService.getAssetsOfEmployee("12345678");
    isResult=true;
   } catch (AssetException e) {
    System.out.println(e.getMessage());
   }
  
  
 
  assertEquals(isResult,true); 

}
@Ignore
@Test
public void testGetAssetsOfEmployeeFailure()
{
 List assetOfEmployee = null;
 boolean isResult=false;
 
  
   try {
    assetOfEmployee =assetService.getAssetsOfEmployee("5555555");
    isResult=true;
   } catch (AssetException e) {
    System.out.println(e.getMessage());
   }
  
  
 
  assertEquals(isResult,false); 

}
@Ignore
@Test
public void testSaveAssetsOfEmployeeSuccess()
{
 String message=null;
 boolean isResult=false;
 
   try {
	message =assetService.saveAssetRequest(AssetType.Desktop, "12345678");
} catch (AuthenticationException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
} catch (AssetException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
}
   isResult=true;
 
  assertEquals(isResult,true); 

}
@Ignore
@Test
public void testSaveAssetsOfEmployeeFailure()
{
 String message=null;
 boolean isResult=false;
 
   try {
	message =assetService.saveAssetRequest(AssetType.Desktop,"11111");
} catch (AuthenticationException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
} catch (AssetException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
}
   isResult=true;
 
  assertEquals(isResult,false); 

}
@Test
public void testGetAllAssetRequestSuccess()
{
 Request request=new Request();
 List requestList = null;
 boolean isResult=false;

  try {
   requestList = assetService.getAllAssetRequests();
   isResult=true;
  } catch (AssetException e) {
   System.out.println(e.getMessage());
  }
  assertEquals(isResult,true); 

}

@Ignore
@Test
public void testGetAllAssetRequestFailure()
{
 Request request=new Request();
 List requestList = null;
 boolean isResult=false;

  try {
   requestList = assetService.getAllAssetRequests();
   isResult=true;
  } catch (AssetException e) {
   System.out.println(e.getMessage());
  }
  assertEquals(isResult,false); 

}
@Ignore
@Test
public void testGetAssetRequestsOfEmployeeSuccess()
{
 Request request=new Request();
 List requestList = null;
 boolean isResult=false;

  try {
   requestList = assetService.getAssetRequests("11111");
   isResult=true;
  } catch (AssetException e) {
   System.out.println(e.getMessage());
  }
  assertEquals(isResult,true); 

}
@Ignore
@Test
public void testGetAssetRequestsOfEmployeeFailure()
{
 Request request=new Request();
 List requestList = null;
 boolean isResult=false;

  
   try {
    requestList = assetService.getAssetRequests("tgthgh");
    isResult=true;
   } catch (AssetException e) {
    System.out.println(e.getMessage());
   }
 
  assertEquals(isResult,false); 

}
@Ignore
@Test
public void allocatedAssetSuccess()
{
 String message=null;
 String isExpected="success";

  try {
	message=assetService.allocateAsset("12345678", 10, "12345678");
} catch (AssetException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
} catch (AuthenticationException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
} catch (EmployeeException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
}

 assertEquals(isExpected, message);
}
@Ignore
@Test
public void allocatedAssetFailure()
{
 String message=null;
 boolean isResult=false;

  try {
	message=assetService.allocateAsset("1234567",6788,"5555555");
} catch (AssetException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
} catch (AuthenticationException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
} catch (EmployeeException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
}
  isResult=true;
 
 assertEquals(isResult,false);
}
@Ignore
@Test
public void deallocatedAssetSuccess()
{
 String message=null;
 String isExpected="success";
 
  try {
	message=assetService.deAllocateAsset(9,"55555555");
} catch (AssetException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
} catch (AuthenticationException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
} catch (EmployeeException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
}

 assertEquals(isExpected, message);
}
@Ignore
@Test
public void deallocatedAssetFailure()
{
 String message=null;
 boolean isResult=false;
 
  try {
	message=assetService.deAllocateAsset(5678,"5555555");
} catch (AssetException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
} catch (AuthenticationException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
} catch (EmployeeException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
}
  isResult=true;

 assertEquals(isResult,false);
}
@Test
public void testGetNewAssetRequestsSuccess()
{
 NewTypeRequest newTypeRequest=new NewTypeRequest();
 List requestList = null;
 boolean isResult=false;

  
   try {
    requestList = assetService.getNewAssetTypeRequests();
    isResult=true;
   } catch (AssetException e) {
    System.out.println(e.getMessage());
   }
   
  
  assertEquals(isResult,true); 

}
@Ignore
@Test
public void testGetNewAssetRequestsFailure()
{NewTypeRequest newTypeRequest=new NewTypeRequest();
List requestList = null;
boolean isResult=false;

 
  try {
   requestList = assetService.getNewAssetTypeRequests();
   isResult=true;
  } catch (AssetException e) {
   System.out.println(e.getMessage());
  }
  
 
assertEquals(isResult,false); 

}
@Ignore
@Test
public void testSaveNewAssetRequestsOfEmployeeSuccess()
{
 
 String requestList = null;
 boolean isResult=false;

  

    try {
		requestList = assetService.saveNewAssetTypeRequest("11111","Desktop","desktop");
	} catch (AuthenticationException e) {
		// TODO Auto-generated catch block
	    System.out.println(e.getMessage());
	} catch (AssetException e) {
		// TODO Auto-generated catch block
	    System.out.println(e.getMessage());
	}
    isResult=true;
   
   
   
  assertEquals(isResult,true); 

}

@Test
public void testSaveAssetRequestsOfEmployeeFailure()
{
 Request request=new Request();
 String requestList = null;
 boolean isResult=false;
 
  try {
	requestList = assetService.saveNewAssetTypeRequest("11111","Desktop","desktop");
} catch (AuthenticationException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
} catch (AssetException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
}
  isResult=true;

 
  assertEquals(isResult,false); 

}
@Test
public void testGetAssetsByTypeSuccess()
{
 Asset asset=new Asset();
 List requestList = null;
 boolean isResult=false;

    try {
     requestList = assetService.getAssetByType(AssetType.Desktop);
     isResult=true;
    } catch (AssetException e) {
     System.out.println(e.getMessage());
    }
   
  assertEquals(isResult,true); 

}
@Ignore
@Test
public void testGetAssetsByTypeFailure()
{Asset asset=new Asset();
List requestList = null;
boolean isResult=false;

   try {
    requestList = assetService.getAssetByType(AssetType.Desktop);
    isResult=true;
   } catch (AssetException e) {
    System.out.println(e.getMessage());
   }
  
assertEquals(isResult,false); 


}
@Ignore
@Test
public void updateAssetSuccess()
{
 String message=null;
 Asset asset=new Asset();
 asset.setAssetName("lappy");
 
 asset.setSerialNumber("1234");
 asset.setAssetType(AssetType.Laptop);
 asset.setStatus(AssetStatus.Available);
 asset.setCost(12344);
 asset.setCreatedBy("5555555");
 asset.setCreatedDate(new Date());
 String expectedResult = "success";
 
 
   try {
	message =assetService.updateAsset(asset);
} catch (AssetException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
} catch (AuthenticationException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
}
 
 
 assertEquals(expectedResult,message);
}
@Ignore
@Test
public void updateAssetFailure()
{
 String message=null;
 Asset asset=new Asset();
 asset.setAssetName("lappy");
 asset.setAssetId(10);
 asset.setSerialNumber("ffghgh");
 asset.setAssetType(AssetType.Laptop);
 asset.setStatus(AssetStatus.Available);
 asset.setCost(12344);
 asset.setCreatedBy("5555555");
 asset.setModifiedBy("12345678");
 asset.setCreatedDate(new Date());
boolean isResult=false;
 
 
   try {
	message =assetService.updateAsset(asset);
} catch (AssetException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
} catch (AuthenticationException e) {
	// TODO Auto-generated catch block
    System.out.println(e.getMessage());
}
   isResult=true;
 
 
 assertEquals(isResult,message);
}
@Test
public void testGetAssetMappingSuccess()
{
 Asset asset=new Asset();
 List assetMappingList = null;
 boolean isResult=false;

    
 try {
  assetMappingList = assetService.getAssetMappingLog();
  isResult=true;
 } catch (AssetException e) {
  System.out.println(e.getMessage());
 }
}     
@Ignore
  @Test
  public void testGetAssetMappingFailure()
  {
   Asset asset=new Asset();
   List assetMappingList = null;
   boolean isResult=false;

      
   try {
    assetMappingList = assetService.getAssetMappingLog();
    isResult=true;
   } catch (AssetException e) {
    System.out.println(e.getMessage());
   }
       
      
     
    assertEquals(isResult,false); 

  }
  @Ignore
  @Test
  public void removeAssetRequestSuccess()
  {
   String message=null;
   Request request=new Request();
   String expectedResult="REMOVED";
   
    
     try {
    message = assetService.removeAssetRequest(request);
     
   } catch (AssetException e) {
    System.out.println(e.getMessage());
   }
    
    
  assertEquals(expectedResult,message);
  }

  @Test
  public void removeAssetRequestFailure()
  {
   String message=null;
   Request request=new Request();
 boolean isResult=false;
  
    try {
     message = assetService.removeAssetRequest(request);
     isResult=true;
    } catch (AssetException e) {
     System.out.println(e.getMessage());
    }
  assertEquals(isResult,false);   
  }


}
 


