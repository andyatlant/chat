package com.chat.common.confirmation;

import com.chat.common.ActionResult;

/**
 * Service for confirmation entities.
 * Allows to generate unique CODE and assign it with required entity.
 * Persists generated CODEs with their assigned entities links to approve the CODEs.
 * Each generated CODE is persisted with creation timestamp.
 * Approving a CODE checking timestamp expiration
 */
public interface ConfirmationService {

    /**
     * Generate code and persist the CODE assigned with entity ID and creation timestamp
     */
    public ActionResult<String> generateConfirmationCode(long entityId);

    /**
     * Get entity ID assigned with input confirmation CODE.
     * If a entity ID is not found return error with message "Unexpected confirmation CODE: <CODE>"
     * If input confirmation CODE is expired  return error with message "Confirmation CODE is expired: <CODE>"
     */
    public ActionResult<Long> checkConfirmationCode(String confirmationCode);

    /**
     * Get expiration time interval in milliseconds for generated CODEs
     */
    public long getExpirationTimeInterval();

}
