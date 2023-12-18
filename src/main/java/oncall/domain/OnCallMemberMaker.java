package oncall.domain;

import oncall.domain.OnCallDayEntry;

import java.util.List;

public interface OnCallMemberMaker {
    public String generate(List<String> members);
}
