package services;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.passman.PasswordManagerException;
import com.wm.util.security.WmSecureString;
import com.wm.app.b2b.server.OutboundPasswordManager;
// --- <<IS-END-IMPORTS>> ---

public final class custom

{
	// ---( internal utility methods )---

	final static custom _instance = new custom();

	static custom _newInstance() { return new custom(); }

	static custom _cast(Object o) { return (custom)o; }

	// ---( server methods )---




	public static final void retrieveSecret (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(retrieveSecret)>> ---
		// @sigtype java 3.5
		// [i] field:0:required secretHandle
		// [i] field:0:required packageName
		// [o] field:0:required secretInPlainTxt
		String handleKey = "secretHandle";
		String packageNameKey = "packageName";
		String secretKey = "secretInPlainTxt";
		
		String handle = ValuesEmulator.getString(pipeline, handleKey);
		String pkgName = ValuesEmulator.getString(pipeline, packageNameKey);
		String PASSMAN_HANDLE_PREFIX = "com.softwareag.cloudstream.";
		String fullHandle = PASSMAN_HANDLE_PREFIX + handle;
		
		//		System.out.println("packageName: " + pkgName + " Full handle: " + fullHandle);
		try {
			WmSecureString secureString = OutboundPasswordManager.retrievePassword(
					pkgName, fullHandle);
			ValuesEmulator.put(pipeline, secretKey, secureString.toString());
		} catch (PasswordManagerException e) {
			e.printStackTrace();
		}
		// --- <<IS-END>> ---

                
	}
}

