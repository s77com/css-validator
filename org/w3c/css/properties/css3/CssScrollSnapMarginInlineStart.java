//
// Author: Yves Lafon <ylafon@w3.org>
//
// (c) COPYRIGHT MIT, ERCIM, Keio, Beihang, 2017.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.css.properties.css3;

import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;
import org.w3c.css.values.CssExpression;
import org.w3c.css.values.CssTypes;
import org.w3c.css.values.CssValue;

/**
 * @spec https://www.w3.org/TR/2017/CR-css-scroll-snap-1-20170824/#propdef-scroll-snap-margin-inline-start
 */
public class CssScrollSnapMarginInlineStart extends org.w3c.css.properties.css.CssScrollSnapMarginInlineStart {

    /**
     * Create a new CssScrollSnapMarginInlineStart
     */
    public CssScrollSnapMarginInlineStart() {
        value = initial;
    }

    /**
     * Creates a new CssScrollSnapMarginInlineStart
     *
     * @param expression The expression for this property
     * @throws org.w3c.css.util.InvalidParamException
     *          Expressions are incorrect
     */
    public CssScrollSnapMarginInlineStart(ApplContext ac, CssExpression expression, boolean check)
            throws InvalidParamException {
        setByUser();
        CssValue val = expression.getValue();

        if (check && expression.getCount() > 1) {
            throw new InvalidParamException("unrecognize", ac);
        }

        switch (val.getType()) {
            case CssTypes.CSS_NUMBER:
                val.getCheckableValue().checkEqualsZero(ac, this);
            case CssTypes.CSS_LENGTH:
                value = val;
                break;
            case CssTypes.CSS_IDENT:
                if (inherit.equals(val)) {
                    value = inherit;
                    break;
                }
            default:
                throw new InvalidParamException("value",
                        expression.getValue(),
                        getPropertyName(), ac);
        }
        expression.next();
    }

    public CssScrollSnapMarginInlineStart(ApplContext ac, CssExpression expression)
            throws InvalidParamException {
        this(ac, expression, false);
    }

}

