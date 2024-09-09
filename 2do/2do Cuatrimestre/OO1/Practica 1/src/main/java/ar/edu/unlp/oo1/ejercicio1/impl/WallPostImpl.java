package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {

	/**
	 * Complete con su implementación
	 */

	private String text;

	private boolean outstanding;
	
	private int likes;
	
    public WallPostImpl() {
    	this.text = "Undefined post";
    	this.outstanding = false;
    	this.likes =0;
    }
    
	@Override
	public String getText() {
		return this.text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int getLikes() {
		return this.likes;
	}

	@Override
	public void like() {
		this.likes++;
	}

	@Override
	public void dislike() {
		if(this.getLikes() > 0) {
			this.likes--;
		}
	}

	@Override
	public boolean isFeatured() {
		return this.outstanding;
	}

	@Override
	public void toggleFeatured() {
		this.outstanding = !this.outstanding;
	}
	
	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";
    }

}
