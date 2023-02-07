package fon.bg.ac.rs.retailApp.services;

import fon.bg.ac.rs.retailApp.models.TextileStatus;

import java.util.List;

public interface TextileStatusService {
    List<TextileStatus> getTextileStatuses();

    TextileStatus saveTextileStatus(TextileStatus textileStatus);
}
